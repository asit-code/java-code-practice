package com.practice.javacode.takeYouForward.basic.recursion;

public class PrintFibonacciNumber {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonaci number is " + printFibonacciNumber(n)); // Tc = O(2^N), Sc = O(N)
    }

    private static int printFibonacciNumber(int n) {
        if (n <= 1)
            return n;

        return printFibonacciNumber(n - 1) + printFibonacciNumber(n - 2);
    }
}
