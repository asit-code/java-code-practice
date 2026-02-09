package com.practice.javacode.takeYouForward.basic.math;

import java.util.Scanner;

public class ReverseDigit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a digit:");
        int n = sc.nextInt();

        int rn = 0;
        while (n > 0) {
            rn = (rn * 10) + (n % 10);
            n = n / 10;
        }

        System.out.println("Reverse no is: " + rn);
    }
}
