package com.practice.javacode.takeYouForward.array.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).
*/

public class NextPermutation {
    public static void main(String args[]) {
        List<Integer> a = Arrays.asList(new Integer[]{2, 1, 5, 4, 3, 0, 0});
        List<Integer> result = findBySpecialWay(a);

        System.out.println("Next Permutation is: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }

    private static List<Integer> findBySpecialWay(List<Integer> a) {
        int n = a.size();
        int index = -1;
        //Find the first dip/break point and store the index.
        for (int i = n - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                index = i;
                break;
            }
        }
        // If no dip the list is the max permutation. Reverse it to get the min permutation.
        if (index == -1) {
            Collections.reverse(a);
            return a;
        }
        //find the next biggest element than the element at index and swap them. traverse from left as we know left side is in decreasing order.
        for (int i = n - 1; i > index; i--) {
            if (a.get(i) > index) {
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                break;
            }
        }
        //Find the left sub list and reverse it to get next greater element.
        List<Integer> sublist = a.subList(index + 1, n);
        Collections.reverse(sublist);
        return a;
    }
}
