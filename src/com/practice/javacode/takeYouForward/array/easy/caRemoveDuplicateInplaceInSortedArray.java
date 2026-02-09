package com.practice.javacode.takeYouForward.array.easy;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.
Note: Return k after placing the final result in the first k slots of the array.

Input: arr[1,1,2,2,2,3,3]

Output: arr[1,2,3,_,_,_,_]
*/
public class caRemoveDuplicateInplaceInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3, 3, 5, 6, 6, 6, 7};
        byTwoPointerApproach(arr); // Tc = O(N), Sc = O(1)
        byHashSetApproach(arr); // Tc = O(NlogN), Sc = O(N)
    }

    private static void byTwoPointerApproach(int[] arr) {
        int Iunique = 0;  //It will hold all unique element
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[Iunique]) {
                Iunique++;
                arr[Iunique] = arr[j];
            }
        }
        System.out.println("Unique element are: ");
        for (int i = 0; i <= Iunique; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void byHashSetApproach(int[] arr) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        int j = 0;
        for (int i : hs) {
            arr[j] = i;
            j++;
        }

        System.out.println("Unique element are: ");
        for (int i = 0; i < hs.size(); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
