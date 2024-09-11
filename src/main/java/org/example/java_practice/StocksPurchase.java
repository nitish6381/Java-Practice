package org.example.java_practice;

import java.util.Scanner;

public class StocksPurchase {
    private int fetchBestProfit(int arr[]){
        int maxProfit = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j< arr.length;j++){
                if(arr[j] - arr[i] > maxProfit){
                    maxProfit = arr[j] - arr[i];
                }
            }
        }
        return maxProfit;
    }

    public int getBestProfit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            System.out.println("Enter the stock price for day " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        return fetchBestProfit(arr);
    }

}
