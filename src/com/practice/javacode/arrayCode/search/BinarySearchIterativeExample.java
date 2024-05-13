package com.practice.javacode.arrayCode.search;

/* Find if the element is prepsent in given array */
public class BinarySearchIterativeExample {

    public int iterativeBinarySearch(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid])
                return mid;
            if (x < arr[mid])         // If x is smaller, ignore right half
                right = mid - 1;
            else
                left = mid + 1;          // If x greater, ignore left half
        }
        return -1;                  // If we reach here, then element was not present
    }

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

}
