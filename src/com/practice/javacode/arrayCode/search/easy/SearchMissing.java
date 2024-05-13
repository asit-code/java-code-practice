package com.practice.javacode.arrayCode.search.easy;

/* Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers */
public class SearchMissing {

    private static void findByIterative(int[] arr, int n) {
        int[] temp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            temp[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            temp[arr[i] - 1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (temp[i] == 0)
                System.out.println("1. missing element: " + (i + 1));
        }

    }

    private static void findBySum(int[] arr, int n) {
        int N = n + 1;
        int totalSum = (N * (N + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("2. MissingElement: " + (totalSum - sum));
    }

    private static void findBySumLight(int[] arr, int n) {
        int totalSum = 1;
        for (int i = 2; i < (n + 1); i++) {
            totalSum += i;
            totalSum -= arr[i - 2];
        }
        System.out.println("3. MissingElement: " + totalSum);
    }

    private static void findByBinary(int[] arr) {
        int xor = 1;
        int n = arr.length;
        for (int i = 2; i <= n + 1; i++) {
            xor = xor ^ i;
        }
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println("4. MissingElement: " + xor);
    }

    private static void findByNegative(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            if (Math.abs(arr[i]) > length)
                continue;
            int ni = Math.abs(arr[i]) - 1;
            arr[ni] *= -1;
        }
        int ans = length + 1;
        for (int i = 0; i < length; i++) {
            if (arr[i] > 0)
                ans = i + 1;
        }
        System.out.println("5. MissingElement: " + ans);
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 6, 7};
        findByIterative(arr, arr.length);
        findBySum(arr, arr.length);
        findBySumLight(arr, arr.length);
        findByBinary(arr);
        findByNegative(arr, arr.length);
    }


}
