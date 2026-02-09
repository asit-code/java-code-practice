package com.practice.javacode.takeYouForward.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSort {
    public static void main(String args[]) {
        int arr[] = {3, 1, 1, 4, 2, 5, 7, 3};
        mergeSorting(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // Time complexity: O(nlogn)    - Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get a sorted array, so overall time complexity will be nlogn
        // Space complexity: O(n)       -  We are using a temporary array to store elements in sorted order.

    }

    private static void mergeSorting(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSorting(arr, low, mid); // left half
        mergeSorting(arr, mid + 1, high); // right half
        merge(arr, low, mid, high); // merging sorted halves
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;         // starting index of left half of arr
        int right = mid + 1;    // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }
}
