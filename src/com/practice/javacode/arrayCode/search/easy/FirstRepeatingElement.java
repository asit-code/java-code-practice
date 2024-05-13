package com.practice.javacode.arrayCode.search.easy;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRepeatingElement {

    private static void findByHashset(int[] arr, int length) {
        HashSet<Integer> set = new HashSet<>();
        int min = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                min = i;
            } else {
                set.add(arr[i]);
            }
        }
        if (min == -1)
            System.out.println("There is no repeating element");
        else
            System.out.println("The first repeating element is: " + arr[min]);
    }

    private static void findByHasing(int[] arr, int n) {
        int max = -1;
        for (int i : arr) {
            if (max < i)
                max = i;
        }

        int[] hash = new int[max + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        int repeat = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] > 1) {
                repeat = arr[i];
                break;
            }
        }

        if (repeat == Integer.MIN_VALUE)
            System.out.println("There is no repeating element");
        else
            System.out.println("The first repeating element is: " + repeat);
    }

    public static void main(String args[]) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        findByHashset(arr, arr.length);
        findByHasing(arr, arr.length);
    }

}
