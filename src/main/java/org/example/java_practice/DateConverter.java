package org.example.java_practice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DateConverter {

    public static List<String> convertDates(List<String> dateStrings) {
        List<String> formattedDates = new ArrayList<>();
        SimpleDateFormat inputFormat = new SimpleDateFormat("d MMM yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (String dateString : dateStrings) {
            String cleanedDateString = dateString.replaceAll("st|nd|rd|th", "");
            try {
                Date date = inputFormat.parse(cleanedDateString);
                String formattedDate = outputFormat.format(date);
                formattedDates.add(formattedDate);
            } catch (ParseException e) {
                System.err.println("Unparseable date: " + cleanedDateString);
                e.printStackTrace(); // Handle the exception as needed
            }
        }
        return formattedDates;
    }

    public static void main(String[] args) {
        List<String> dateStrings = new ArrayList<>();
        dateStrings.add("1st Oct 1345");
        dateStrings.add("4th Jun 2345");
        dateStrings.add("25th Apr 2034");
        dateStrings.add("26th May 3456");

        List<String> formattedDates = convertDates(dateStrings);
        for (String date : formattedDates) {
            System.out.println(date);
        }
    }
}
