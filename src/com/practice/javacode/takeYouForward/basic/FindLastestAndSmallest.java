package com.practice.javacode.takeYouForward.basic;

import java.util.HashMap;
import java.util.Map;

public class FindLastestAndSmallest {

    public static void main(String args[]) {
        int a[] = {5, 10, 51, 5, 10, 20, 5};
        findByMap(a, a.length);
        // Time Complexity: O(N), where N = size of the array. The insertion and retrieval operation in the map takes O(1) time.
        // Space Complexity:  O(N), where N = size of the array. It is for the map we are using.
    }

    private static void findByMap(int[] a, int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        int fmax = 0, fmin = n;
        int emax = 0, emin = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(a[i])) {
                int count = hm.get(a[i]);
                hm.put(a[i], count + 1);
            } else {
                hm.put(a[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            if (fmax < count) {
                fmax = count;
                emax = element;
            }
            if (fmin > count) {
                fmin = count;
                emin = element;
            }
        }
        System.out.println("Highest element frequency is: " + fmax);
        System.out.println("Lowest element frequency is: " + fmin);

    }
}
