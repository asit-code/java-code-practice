package com.practice.javacode.takeYouForward.basic.recursion;

import java.util.Scanner;

public class CheckPalindromeString {

    private static void checkPalindromeByRecursion(String str, int i) {
        if (i >= str.length()/2) {
            System.out.println("String is Palindrome");
            return;
        }
        if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
            checkPalindromeByRecursion(str, i+1);
        } else {
            System.out.println("String is not a Palindrome");
            return;
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.next();
        int i = 0;
        checkPalindromeByRecursion(str, i);
    }
}
