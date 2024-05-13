package com.practice.javacode.arrayCode.search;

/* Find if the element is prepsent in given array */

public class BinarySearchRecursiveExample {

    public int iterativeBinarySearch(int arr[], int x, int l, int r) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            if (x == arr[m])
                return m;
            if (x < arr[m])              // If element is smaller than mid, then it can only be present in left subarray
                return iterativeBinarySearch(arr, x, l, m - 1);

            return iterativeBinarySearch(arr, x, m + 1, r);    // Else the element can only be present in right subarray
        }

        return -1;
    }

    public static void main(String args[]) {
        BinarySearchRecursiveExample ob = new BinarySearchRecursiveExample();
        int arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int x = 38;
        int l = 0;
        int r = arr.length - 1;
        int index = ob.iterativeBinarySearch(arr, x, l, r);
        if (index == -1) {
            System.out.println("Element: " + x + " is not present in the array");
        } else {
            System.out.println("Element: " + x + " is present at index: " + index + " in the array");
        }
    }


}
