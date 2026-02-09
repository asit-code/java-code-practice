package com.practice.javacode.takeYouForward.array.medium;

/*Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.*/

public class MaximumSubArrayKadanesAlgo {
    public static void main(String args[]) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        findByBF(arr, arr.length);          //Tc = O(n2), Sc =O(1)
        findByKadanesAlgo(arr, arr.length); //Tc =O(n), Sc =(1)
    }

    private static void findByBF(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("Maximum sub array sum: " + maxSum);
        System.out.println("Sub array is: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void findByKadanesAlgo(int[] arr, int n) {
        int sum = 0;
        int start = -1, end = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
                end = i;
            }
        }
        System.out.println("Maximum sub array sum: " + maxSum);
        System.out.println("Start: " + start + " end:" + end);
    }

}
