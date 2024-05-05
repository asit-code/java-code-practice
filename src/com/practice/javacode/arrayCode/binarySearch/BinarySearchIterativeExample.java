package com.practice.javacode.arrayCode.binarySearch;

public class BinarySearchIterativeExample {
    public static void main(String args[]) {
        BinarySearchIterativeExample ob = new BinarySearchIterativeExample();
        int arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int x = 2;
        int index = ob.iterativeBinarySearch(arr, x);
        if (index == -1) {
            System.out.println("Element: " + x + "is not present in the array");
        } else {
            System.out.println("Element: " + x + " is present at index: " + index + " in the array");
        }
    }

    public int iterativeBinarySearch(int arr[], int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (x == arr[m])
                return m;
            if (x < arr[m])         // If x is smaller, ignore right half
                r = m - 1;
            else
                l = m + 1;          // If x greater, ignore left half
        }
        return -1;                  // If we reach here, then element was not present
    }



}
