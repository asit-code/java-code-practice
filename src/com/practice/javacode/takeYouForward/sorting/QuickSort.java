package com.practice.javacode.takeYouForward.sorting;

public class QuickSort {
    //Pick a pivot and move all smaller elements to left and larger elements to right of pivot.
    //Repeat the process for left and right sub-arrays.


    public static void main(String args[]) {
        int arr[] = {5, 3, 2, 1, 4, 5, 9, 3};
        quickSortImpl(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Time Complexity: O(N*logN), where N = size of the array.
        // Reason: At each step, we divide the whole array, for that logN and n steps are taken for partition() function, so overall time complexity will be N*logN.
        // Space Complexity: O(1) + O(N) auxiliary stack space.
    }

    private static void quickSortImpl(int[] arr, int low, int high) {
        if (low < high) {
            int partition = findPartition(arr, low, high); // choose a low as pivot, move all small to left and large to right of pivot and move pivot to its place and return its index.
            quickSortImpl(arr, low, partition - 1);
            quickSortImpl(arr, partition + 1, high);
        }
    }

    private static int findPartition(int[] arr, int low, int high) {
        int pivot = low; // choosing 1st element as pivot
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= arr[pivot] && i <= high - 1) { //Keep increasing i till arr[i] is greater that pivot
                i++;
            }
            while (arr[j] > arr[pivot] && j >= low + 1) {  //Keep decreasing j till arr[j] is less that pivot
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        return j;
    }
}
