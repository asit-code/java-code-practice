package com.practice.javacode.takeYouForward.array.easy;

import java.util.Arrays;

/*Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n. */
public class FindPairWithGivenDiff {

    private static void findBySorting(int[] arr, int n, int key) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        key = Math.abs(key);
        while (i < n && j < n) {
            int diff = arr[j] - arr[i];
            if (diff == key && (i != j)) {
                System.out.println("Pair found: " + arr[i] + ", " + arr[j]);
                return;
            } else if (diff > n) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println("No such pair found.");
        return;
    }

    public static void main(String args[]) {

        int[] arr = {1, 8, 30, 40, 100};
        int key = -60;
        findBySorting(arr, arr.length, key); // T = O(nlogn), S = O(1)

    }


    /* Hashing can also be used to solve this problem. Create an empty hash table HT. Traverse the array, use array elements as hash keys and enter them in HT. Traverse the array again look for value n + arr[i] in HT. */

}
