package com.practice.javacode.takeYouForward.array.easy;

public class baCheckIfArrayIsSorted {
    public static void main(String args[]) {
        int arr1[] = {3, 5, 66, 76, 81, 83, 100, 200, 250};
        int arr2[] = {3, 6, 8, 4, 9, 11, 25, 45};
        checkSortedArray(arr1);
        checkSortedArray(arr2);

    }

    private static void checkSortedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("Array is not sorted.");
                return;
            }
        }
        System.out.println("Array is sorted.");
    }
}
