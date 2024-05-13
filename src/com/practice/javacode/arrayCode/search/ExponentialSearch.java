package com.practice.javacode.arrayCode.search;


import java.util.ArrayList;
import java.util.Arrays;

public class ExponentialSearch {

    public static int findItemindex(ArrayList<Integer> arr, int k) {

        if (arr.get(0) == k)
            return 0;
        int n = arr.size();
        int i = 1;
        while (i < n && arr.get(i) < k) {
            i *= 2;
        }
        int left = i / 2;
        int right = Math.min(i, n - 1);

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == k) {
                return mid;
            } else if (k > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 10, 40));
        int k = 10;
        int index = findItemindex(list, k);
        if (index == -1) {
            System.out.println("Key is not present.");
        } else {
            System.out.println("Key: " + k + " is present at index: " + index);
        }
    }
}
