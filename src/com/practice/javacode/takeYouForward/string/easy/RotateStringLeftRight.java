package com.practice.javacode.takeYouForward.string.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RotateStringLeftRight {
    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        int d = 15;
        rotateByTempString(str, d);
        rotateByDeque(str, d);
        rotateByTwoLoop(str, d);
    }

    private static void rotateByTempString(String str, int d) {
        System.out.println("TempString");

        d = d % str.length();
        int n = str.length();
        String result = str.substring(d) + str.substring(0, d);
        System.out.println("Rotate left by: " + d + " is: " + result);

        String result2 = str.substring(n - d) + str.substring(0, n - d);
        System.out.println("Rotate right by: " + d + " is: " + result2);

    }

    private static void rotateByDeque(String str, int d) {
        char[] ch = str.toCharArray();
        d = d % ch.length;
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : ch) {
            dq.add(c);
        }
        for (int i = 0; i < d; i++) {
            char first = dq.removeFirst();
            dq.addLast(first);
        }
        StringBuffer sb = new StringBuffer();
        for (char chr : dq) {
            sb.append(chr);
        }
        System.out.println("Rotate left by Deque: " + sb);
    }

    private static void rotateByTwoLoop(String str, int d) {
        d = d % str.length();
        int n = str.length();
        char[] ch = str.toCharArray();
        for (int i = 0; i < d; i++) {
            char first = ch[0];
            for (int j = 0; j < n - 1; j++) {
                ch[j] = ch[j + 1];
            }
            ch[n - 1] = first;
        }
        System.out.println("Rotating left by two loop: " + String.valueOf(ch));
    }
}
