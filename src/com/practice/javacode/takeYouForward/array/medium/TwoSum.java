package com.practice.javacode.takeYouForward.array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers arr[] and an integer target. Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.*/
public class TwoSum {
    public static void main(String args[]) {
        int[] arr = {2, 6, 5, 8, 11};
        int sum = 14;
        findByHashing(arr, sum); // Tc = O(N), Sc = O(N)
        findByTwoPointer(arr, sum); // Tc = O(N) + O(NlogN), Sc = O(1)
    }

    private static void findByHashing(int[] arr, int sum) {
        int first = -1;
        int second = -1;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(sum - arr[i])) {
                first = i;
                second = hm.get(sum - arr[i]);
                break;
            } else {
                hm.put(arr[i], i);
            }
        }
        System.out.println("Two elements are, First: " + first + ", Second: " + second);
    }

    private static void findByTwoPointer(int[] arr, int sum) {
        Arrays.sort(arr);  //Tc = NlogN
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int k = arr[left] + arr[right];
            if (k == sum) {
                System.out.println("Two elements are, First: " + left + ", Second: " + right);
                return;
            } else if (k > sum) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("Two elements are, First: -1,  Second: -1");
    }
}
