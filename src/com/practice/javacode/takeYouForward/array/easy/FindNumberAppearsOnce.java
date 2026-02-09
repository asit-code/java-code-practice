package com.practice.javacode.takeYouForward.array.easy;

import java.util.HashMap;
import java.util.Map;

/* Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.*/
public class FindNumberAppearsOnce {
    public static void main(String[] args) {
        int arr[] = {4, 1, 2, 1, 2};
        findByMapMethod(arr);
        findByXor(arr);
    }

    private static void findByMapMethod(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println("Non-repeating element is: " + e.getKey());
                return;
            }
        }
        System.out.println("Non-repeating element is not present");
    }

    private static void findByXor(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println("Non-repeating element by xor is: " + xor);
    }
}
