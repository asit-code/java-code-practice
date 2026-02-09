package com.practice.javacode.takeYouForward.basic.math;

import java.util.Scanner;

public class FindGCD {

    private static int gcdByBF(int n1, int n2) {
        int gcd = 1;
        int min = Math.min(n1, n2);
        for (int i = min; i > 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
                return gcd;
            }
        }
        return gcd;
    }

    private static int gcdByEuclidean(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2)
                n1 = n1 % n2;
            else
                n2 = n2 % n1;
        }
        if (n1 == 0)
            return n2;
        else
            return n1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n1 = ");
        int n1 = sc.nextInt();
        System.out.println("n2 = ");
        int n2 = sc.nextInt();

        int gcd1 = gcdByBF(n1, n2);             //Tc = min(n1,n2), Sc = 1
        System.out.println("GCD: " + gcd1);

        int gcd2 = gcdByEuclidean(n1, n2);
        System.out.println("GCD: " + gcd2);     // Tc = logc Min(n1,n2), Sc = 1

    }


    /*
     * The Euclidean Algorithm is a method for finding the greatest common divisor of two numbers. It operates on the principle that the GCD of two numbers remains the same even if the smaller number is subtracted from the larger number.
     * Once one of them becomes 0, the other number is the GCD of the original numbers.
     *
     * */


}
