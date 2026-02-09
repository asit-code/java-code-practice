package com.practice.javacode.takeYouForward.array.medium;

/*You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/

public class BuyThenSellStock {
    public static void main(String args[]) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        findByBruteForce(arr, arr.length); // Tc = O(n2), Sc =O(1)
        findByOptimal(arr, arr.length); // Tc = O(n), Sc =O(1)
    }

    private static void findByBruteForce(int[] arr, int n) {
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i])
                    maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
            }
        }
        System.out.println("Max profit after can be by BF : " + maxProfit);
    }

    private static void findByOptimal(int[] arr, int n) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            /*if (arr[i] <= min) {
                min = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - min);
            }*/
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        System.out.println("Max profit after can be :" + maxProfit);
    }
}
