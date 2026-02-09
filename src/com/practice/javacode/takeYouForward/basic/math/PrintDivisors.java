package com.practice.javacode.takeYouForward.basic.math;

import java.util.Scanner;

public class PrintDivisors {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a Number");
        int n = sc.nextInt();

        System.out.println("Divisors of the number are: ");
        int sq = (int) Math.sqrt(n);
        for (int i = 1; i <= sq; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
                if (n / i != i) {
                    System.out.print(n / i + ",");
                }
            }

        }
    }

    /*
     Tc = O(sqrt(n)), Sc = O(2*sqrt(n))

     * We can optimise the previous approach by using the property that for any non-negative integer n, if d is a divisor of n then n/d is also a divisor of n.
     * This property is symmetric about the square root of n by traversing just the first half we can avoid redundant iteration and computations improving the efficiency of the algorithm.
     * */
}
