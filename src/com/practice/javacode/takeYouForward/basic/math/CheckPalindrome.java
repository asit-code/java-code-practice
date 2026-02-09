package com.practice.javacode.takeYouForward.basic.math;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int temp = n;
        int rn = 0;

        while (temp > 0) {
            rn = (10 * rn) + (temp % 10);
            temp = temp / 10;
        }
        if(n==rn)
            System.out.println("it is a Palinderome");
        else
            System.out.println("It is not a Palindrome");

    }
}
