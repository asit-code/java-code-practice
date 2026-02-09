package com.practice.javacode.takeYouForward.string.easy;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "GeeksOfGeeks";
        reverseStringByLoop(str);
        reverseStringByinBuildMethod(str);
        char[] ch = str.toCharArray();
        reverseStringByRecursion(ch, 0);
        System.out.println("By recursion: " + String.valueOf(ch));
        reverseStringByTwoPointer(str);
        reverseStringbyStack(str);
    }

    private static void reverseStringByLoop(String str) {
        char[] ch = str.toCharArray();
        int n = str.length();
        StringBuffer result = new StringBuffer();
        for (int i = n - 1; i >= 0; i--) {
            result.append(ch[i]);
        }
        System.out.println("result: " + result);
    }

    private static void reverseStringByinBuildMethod(String str) {
        StringBuffer result = new StringBuffer(str);
        System.out.println("result: " + result.reverse());
    }

    private static void reverseStringByRecursion(char[] ch, int i) {
        int n = ch.length;
        while (i == n / 2)
            return;
        swap(ch, i, n - 1 - i);
        reverseStringByRecursion(ch, i + 1);
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    private static void reverseStringByTwoPointer(String str) {
        char[] ch = str.toCharArray();
        int n = ch.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
        System.out.println("By two pointer: " + String.valueOf(ch));
    }

    private static void reverseStringbyStack(String str) {
        char[] ch = str.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            st.add(ch[i]);
        }
        for (int i = 0; i < str.length(); i++) {
            ch[i] = st.pop();
        }
        System.out.println("By Stack: " + String.valueOf(ch));

    }
}
