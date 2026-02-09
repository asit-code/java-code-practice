package com.practice.javacode.takeYouForward.sorting;

public class SelectionBubbleInsertionSort {
    public static void main(String args[]) {
        int arr[] = {34, 5, 32, 55, 6, 7, 3};
        selectionSort(arr, arr.length); // Time complexity: O(N2), (where N = size of the array), for the best, worst, and average cases.
        bubbleSort(arr, arr.length); // Time complexity: O(N2), (where N = size of the array), for the worst, and average cases.
        insertionSort(arr, arr.length); // Time complexity: O(N2), (where N = size of the array), for the worst, and average cases.
    }

    //Select an element in each iteration from the unsorted array(using a loop), place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
    private static void insertionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        System.out.println("Insertion sort");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // Find the smallest element and move to starting index.
    // Assume starting index as smallest and compare the array and get the index of smallest element and swap with 1st index.
    private static void selectionSort(int[] arr, int n) {
        for (int i = 0; i <= n - 2; i++) {
            int min = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println("Selection sort");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    //check two adjacent element and swap the largest element to right => last element of array will have the largest element.
    //continue this process by reducing the array from right.
    private static void bubbleSort(int[] arr, int n) {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= (i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Bubble sort");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

}
