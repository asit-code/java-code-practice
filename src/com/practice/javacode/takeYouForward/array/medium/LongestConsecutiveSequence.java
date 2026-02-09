package com.practice.javacode.takeYouForward.array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.*/

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
            int arr[] = {1, 1, 100, 102, 1, 3, 2, 4, 101};
        findByBF(arr, arr.length);          // Tc =O(n2), Sc = O(1)
        findBySorting(arr, arr.length);     // Tc =O(nlogn) + O(N), Sc =O(1)
        findBySet(arr, arr.length);         // Tc = O(3N), Sc =O(n)
    }

    private static void findByBF(int[] arr, int n) {
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int cnt = 1;
            while (isPresent(arr, x + 1) == true) {
                x = x + 1;
                cnt++;
            }
            longest = Math.max(longest, cnt);
        }
        System.out.println("Longest consecutive sequence in array by BF is: " + longest);
    }

    private static boolean isPresent(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;

    }

    private static void findBySorting(int[] arr, int n) {
        Arrays.sort(arr);    // Tc = O(nlogn)
        int longest = 1;
        int lastSmallest = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmallest) {
                count++;
                lastSmallest = arr[i];
            } else if (arr[i] == lastSmallest) {
                //Do nothing - as it is a repetitive number
            } else if (arr[i] != lastSmallest) {
                count = 1;
                lastSmallest = arr[i];
            }
            longest = Math.max(longest, count);
        }

        System.out.println("Longest consecutive sequence in array by Sorting is: " + longest);

    }

    private static void findBySet(int[] arr, int n) {
        Set<Integer> hs = new HashSet<>(); // Set used here to make comparison O(1) and in worst case O(n).
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        int longest = 1;
        for (Integer e : hs) {
            if (!hs.contains(e - 1)) {
                int count = 1;
                int x = e;
                while (hs.contains(x + 1)) {
                    count++;
                    x += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        System.out.println("Longest consecutive sequence in array by HashSet is: " + longest);

    }
}
