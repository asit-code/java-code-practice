package com.practice.javacode.takeYouForward.basic.math;

import java.util.Scanner;

public class CheckPrime {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");

        int n = sc.nextInt();
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                counter++;
                if (n / i != i)
                    counter++;
            }
        }
        if (counter == 2)
            System.out.println("it is a prime number.");
        else
            System.out.println("It is not a prime number.");
    }

}
