package com.practice.javacode.arrayCode.search.easy;

import java.util.Arrays;

/* Given a binary array arr[] of size N, which is sorted in non-increasing order, count the number of 1’s in it. */
public class Count1sInsortedArray {

    private static int findByIterative(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((arr[mid] == 1) && (mid == r || arr[mid + 1] == 0)) { // if mid element is 1 and last element or next element is 0, then result
                return mid + 1;
            } else if ((arr[mid] == 1)) { // mid and next element is 1  - opitonal  ((arr[mid] == 1)&& (arr[mid + 1] == 1))
                l = mid + 1;
            } else if (arr[mid] == 0) { //if mid element is not 1.
                r = mid - 1;
            }
        }
        return 0;
    }

    private static int findByResursive(int[] arr, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if ((arr[mid] == 1) && (mid == r || arr[mid + 1] == 0)) {
                return mid + 1;
            } else if (arr[mid] == 1) {
                return findByIterative(arr, (mid + 1), r);
            } else {
                return findByIterative(arr, l, (mid - 1));
            }
        }
        return 0;
    }


    public static void main(String args[]) {
        int arr[] = {1, 1, 1, 1, 1, 1, 0, 0, 0};
        int count1 = findByIterative(arr, 0, arr.length - 1); // T = O(logn), S = O(1)
        int count2 = findByResursive(arr, 0, arr.length - 1); // T = O(logn), S = O(1)
        System.out.println("Count of 1: " + count1);
        System.out.println("Count of 1: " + count2);
        long count3 = Arrays.stream(arr).filter(i -> i == 1).count();
        System.out.println("Count of 1 by in build funtion: " + count3); // T = O(n), S = O(1)
    }

}
