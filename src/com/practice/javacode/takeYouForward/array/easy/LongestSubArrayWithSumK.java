package com.practice.javacode.takeYouForward.array.easy;

/*Given an array and a sum k, we need to print the length of the longest subarray that sums to k. ()+ve only*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) {
        int arr[] = {1, 9, 2, 3, 5};
        int k = 10;
        findByBF(arr, k); // Tc = O(N*N), Sc = O(1)
        //Best solution for both +ve, -ve and 0 as array element
        int[] a = { -1, 1, 1};
        findByHashing(a, 1); // Tc = O(N*1) for unordered map, worst case in collision Tc = O(N*N), Sc = O(N)
        //If we take TreeMap(Ordered map), Tc = O(NlogN), Sc = O(N)
        //Best solution for only +ve element.
        findByTwoPointer(arr, k); //Tc =O(2*N), Sc = O(1)
    }

    private static void findByBF(int[] arr, int k) {
        int n = arr.length;
        int longest = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        System.out.println("Longest sub array with sum 10: " + longest);
    }

    private static void findByHashing(int[] arr, int k) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        long sum = 0L;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            if (prefixMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixMap.get(sum - k));
            }
            if (!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }
        System.out.println("Longest sub array with sum 1: " + maxLength);
    }

    private static void findByTwoPointer(int[] arr, int k) {
        long sum = arr[0];
        int maxLenght = 0;
        int left = 0, right = 0;
        int n = arr.length;

        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLenght = Math.max(maxLenght, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) {
                sum += arr[right];
            }

        }
        System.out.println("Longest sub array with sum 10: " + maxLenght);
    }
}
