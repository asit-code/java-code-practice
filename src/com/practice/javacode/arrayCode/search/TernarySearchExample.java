package com.practice.javacode.arrayCode.search;

/* Find if the element is prepsent in given array */

public class TernarySearchExample {

    public int findInputIndexByIterative(int[] arr, int k, int left, int right) {

        while (left <= right) {

            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == k)
                return mid1;
            if (arr[mid2] == k)
                return mid2;

            if (k < arr[mid1]) {
                right = mid1 - 1;
            } else if (k > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    public int findInputIndexByResursive(int[] arr, int k, int left, int right) {
        if (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (k == arr[mid1])
                return mid1;
            if (k == arr[mid2])
                return mid2;

            if (k < arr[mid1]) {
                return findInputIndexByResursive(arr, k, left, mid1 - 1);
            } else if (k > arr[mid2]) {
                return findInputIndexByResursive(arr, k, mid2 + 1, right);
            } else {
                return findInputIndexByResursive(arr, k, mid1 + 1, mid2 - 1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TernarySearchExample ob = new TernarySearchExample();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int left = 0;
        int right = arr.length - 1;
        int k = 6;
        int result = ob.findInputIndexByResursive(arr, k, left, right);
        if (result == -1) {
            System.out.println("Element: " + k + " is not present in the array");
        } else {
            System.out.println("Element: " + k + " is present in at index: " + result);

        }
    }
}
