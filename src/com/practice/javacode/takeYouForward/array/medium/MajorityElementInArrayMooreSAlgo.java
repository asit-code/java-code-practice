package com.practice.javacode.takeYouForward.array.medium;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
 */
public class MajorityElementInArrayMooreSAlgo {
    public static void main(String args[]) {
        int arr[] = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4};
        byhashing(arr, arr.length); // Tc = O(N), Sc = O(N)
        byMooresAlgo(arr, arr.length); // Tc = O(N), Sc = O(1)
    }

    private static void byhashing(int[] arr, int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = hm.getOrDefault(arr[i], 0);
            hm.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > n / 2) {
                System.out.println("Majority element is : " + e.getKey());
            }
        }
    }

    private static void byMooresAlgo(int[] arr, int n) {
        int el = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if (arr[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el)
                count++;
        }
        if (count > n / 2)
            System.out.println("Majority element by Moor's algo is : " + el);
    }

}
