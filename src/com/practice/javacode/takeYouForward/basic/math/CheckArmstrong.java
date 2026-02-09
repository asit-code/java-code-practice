package com.practice.javacode.takeYouForward.basic.math;

public class CheckArmstrong {

    private static void checkArmstrongNumber(int n) {
        int length = String.valueOf(n).length();
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int ld = temp % 10;
            sum += (int) Math.pow(ld, length);
            temp = temp / 10;
        }
        if (sum == n)
            System.out.println("It is a armstrong number.");
        else
            System.out.println("It is not a armstrong number.");
    }

    public static void main(String args[]) {
        int n = 153;
        checkArmstrongNumber(n);   // Tc = log10 n + 1.
    }


}
