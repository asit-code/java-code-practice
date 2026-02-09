package com.practice.javacode.takeYouForward.array.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Case-1:
There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.
Note: Start the array with positive elements.

case-2:
There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.
Note: Start the array with positive elements.
*/
public class ArrangeElementBySize {
    public static void main(String args[]) {
        // case:1
        int arr1[] = {1, 2, -3, -1, -2, 3};
        arrangeByBF1(arr1);         //Tc = O(n+n/2) , Sc = O(n/2 +n/2) = O(n)
        arrangeByOptimal(arr1);     //Tc = O(n) , Sc = O(n)

        // case:2
        int arr2[] = {1, 2, -3, -1, -2, -3};
        arrangeByBF2(arr2);         //Tc = O(2n) , Sc = O(n/2 +n/2) = O(n)
    }

    private static void arrangeByBF1(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }

        System.out.println("Result array by BF1: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    private static void arrangeByOptimal(int[] arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.length, 0));
        int pos = 0, neg = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result.set(pos, arr[i]);
                pos += 2;
            } else {
                result.set(neg, arr[i]);
                neg += 2;
            }
        }

        System.out.println("Result array by optimal 1: ");
        for (Integer e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static void arrangeByBF2(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[i * 2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }

            int arrIndex = neg.size() * 2;
            for (int i = neg.size() * 2; i < pos.size(); i++) {
                arr[arrIndex] = pos.get(i);
                arrIndex++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[i * 2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }

            int arrIndex = pos.size() * 2;
            for (int i = pos.size() * 2; i < neg.size(); i++) {
                arr[arrIndex] = neg.get(i);
                arrIndex++;
            }
        }

        System.out.println("Result array by BF2: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
