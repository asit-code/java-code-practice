package com.practice.javacode.arrayCode.search.easy;

import java.util.Arrays;

public class SumCloseToZero {

    private static int closeToZero(int[] arr, int n) {
        Arrays.sort(arr);

        //boundary conditions
        if (n < 2) {                                // If only 1 element in array, return double
            return 2 * arr[0];
        } else if (arr[0] > 0) {                    //If only +ve, return sum of 1st 2 element
            return arr[0] + arr[1];
        } else if (arr[n - 1] < 0) {                //If only -ve, return sum of last 2 element
            return arr[n - 1] + arr[n - 2];
        }

        // the array is mix of +ve and -ve
        int l = 0, r = n - 1, minSum = Integer.MAX_VALUE;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (Math.abs(sum) < Math.abs(minSum))
                minSum = sum;

            if (Math.abs(sum) == Math.abs(minSum)) // If sum of two different pair is same then, prefer +ve one.
                minSum = Math.max(sum, minSum);

            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                return 0;
            }

        }
        return minSum;


    }

    public static void main(String args[]) {
        int[] arr = {1, 60, -10, 70, -80, 85};
        int sum = closeToZero(arr, arr.length); // T = O(nlogn), S = O(1)
        System.out.println("Sum: " + sum);
    }
}
