package com.practice.javacode.takeYouForward.basic.recursion;

import java.util.Scanner;

public class FactorialOfNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int result = factorialByRecursive(n);
        System.out.println("Factorial is: " + result);
    }

    private static int factorialByRecursive(int n) {
        if (n == 1)
            return 1;
        return n * factorialByRecursive(n - 1);
    }
}
