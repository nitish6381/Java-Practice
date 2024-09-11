package org.example.java_practice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GoogleScraper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String outputFilePath = "googleSearchResult.txt";

        System.out.println("Welcome to the Google!");
        System.out.println("You can enter multiple search queries.");
        System.out.println("Type 'exit' to terminate the program.\n");

        while (true) {
            // Prompt user for input
            System.out.print("Enter a word or phrase to search on Google (or type 'exit' to quit): ");
            String query = scanner.nextLine().trim();

            // Exit condition
            if (query.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Google Scraper. Goodbye!");
                break;
            }

            // Skip empty queries
            if (query.isEmpty()) {
                System.out.println("Empty input detected. Please enter a valid search query.\n");
                continue;
            }

            String googleSearchURL = "https://www.google.com/search?q=" + query.replace(" ", "+");

            try {
                // Fetch the Google search results page
                Document doc = Jsoup.connect(googleSearchURL)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "Chrome/58.0.3029.110 Safari/537.3")
                        .get();

                // Extract the search result links
                Elements links = doc.select("a[href]");

                StringBuilder scrapedData = new StringBuilder();

                // Adding header with date and time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                scrapedData.append("============================================================\n");
                scrapedData.append("Search Results for: ").append(query).append("\n");
                scrapedData.append("Searched At: ").append(dtf.format(now)).append("\n");
                scrapedData.append("============================================================\n\n");

                int count = 1;

                for (Element link : links) {
                    if (count > 10) {
                        break;
                    }
                    String href = link.attr("href");

                    // Check if the href is a valid Google search result link
                    if (href.startsWith("/url?q=")) {
                        int indexOfAnd = href.indexOf("&");
                        if (indexOfAnd == -1) {
                            continue;
                        }
                        String cleanUrl = href.substring(7, indexOfAnd);
                        cleanUrl = URLDecoder.decode(cleanUrl, StandardCharsets.UTF_8);

                        // Filter out non-useful links
                        if (cleanUrl.contains("accounts.google.com") ||
                                cleanUrl.contains("support.google.com") ||
                                cleanUrl.contains("policies.google.com") ||
                                cleanUrl.contains("preferences") ||
                                cleanUrl.contains("webcache.googleusercontent.com") ||
                                cleanUrl.contains("youtube.com/watch") || // Often ads or unrelated videos
                                cleanUrl.contains("google.com/search") || // Avoid internal Google searches
                                cleanUrl.contains("maps.google.com") ||   // Exclude Google Maps
                                cleanUrl.contains("shopping")) {           // Exclude Google Shopping
                            continue;
                        }

                        // Ensure the link has meaningful text and is not a generic service link like "Maps" or "Shopping"
                        String linkText = link.text();
                        if (linkText == null || linkText.trim().isEmpty() ||
                                linkText.equalsIgnoreCase("Maps") ||
                                linkText.equalsIgnoreCase("Shopping")) {
                            continue;
                        }

                        // Append the formatted result
                        scrapedData.append(count)
                                .append(". ")
                                .append(linkText)
                                .append("\n   ")
                                .append(cleanUrl)
                                .append("\n\n");
                        count++;
                    }
                }

                // Handle cases where no results were found
                if (count == 1) {
                    scrapedData.append("No valid search results found for the query: ").append(query).append("\n\n");
                }

                // Append the results to the file
                try {
                    Files.write(Paths.get(outputFilePath), scrapedData.toString().getBytes(),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Search results for '" + query + "' have been appended to " + outputFilePath + "\n");
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }

            } catch (IOException e) {
                System.err.println("Network or parsing error: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
    }
}

