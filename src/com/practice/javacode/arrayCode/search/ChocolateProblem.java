package com.practice.javacode.arrayCode.search;

/* Find maximum height to cut all chocolates horizontally such that at least K amount remains */

import java.util.Arrays;

public class ChocolateProblem {

    public static boolean validSum(int arr[], int k, int high) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > high) {
                sum += arr[i] - high;
            }
        }
        return sum > k;
    }

    public static int maxCut(int arr[], int k) {
        /* Range of binary search */
        int low = 0;
        int[] a = arr.clone();
        Arrays.sort(a);
        int high = a[a.length - 1];
        //int high = Arrays.stream(arr).max().getAsInt();

        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (validSum(arr, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }

        }
        // After binary search we get 2 elements
        // high and low which we can manually compare
        if (validSum(arr, k, high)) {
            return high;
        } else {
            return low;
        }

    }

    public static void main(String[] args) {
        int arr[] = {30, 25, 22, 17, 20};
        int k = 12;
        System.out.println("max cut = " + maxCut(arr, k));
    }
}
