package com.practice.javacode.takeYouForward.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedArray {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 4, 4, 6, 9};
        ArrayList<Integer> result1 = byUsingSet(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Sorted array by Map: ");
        for (Integer i : result1) {
            System.out.print(i + " ");
        }

        ArrayList<Integer> result2 = byUsingTwoPointer(arr1, arr2);
        System.out.println();
        System.out.println("Sorted array by two pointer: ");
        for (Integer i : result2) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> byUsingTwoPointer(int[] arr1, int[] arr2) {
        ArrayList<Integer> union = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        while (i < m && i < n) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) { // check to avoid saving duplicate
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {   // IF any element left in arr1
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }

    private static ArrayList<Integer> byUsingSet(int[] arr1, int[] arr2, int m, int n) {
        Set<Integer> ts = new TreeSet<>();
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ts.add(arr1[i]);
        }
        for (int i = 0; i < n; i++) {
            ts.add(arr2[i]);
        }
        for (Integer i : ts) {
            union.add(i);
        }

        return union;
    }
}
