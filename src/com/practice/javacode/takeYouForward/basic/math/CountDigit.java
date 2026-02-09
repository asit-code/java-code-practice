package com.practice.javacode.takeYouForward.basic.math;

public class CountDigit {

    private static int countDigitsByBF(int n) {
        int count = 0;
        while(n>0){
            count++;
            n = n/10;
        }
        return count;
    }

    private static int countDigitsByLog(int n) {
        int count = (int) (Math.log10(n) +1);
        return count;
    }

    public static void main(String[] args) {
        int N = 329823;
        System.out.println("N: " + N);
        int digits = countDigitsByBF(N);
        System.out.println("Number of Digits in N: " + digits);
        int digit = countDigitsByLog(N);
        System.out.println("Number of Digits in N: " + digit);
    }


    /*
    * log10 N operation gives the logarithmic base 10 of which returns the power to which 10 must be raised to, to be equal to N.
    * We add 1 to the result which accounts for the possibility that N itself is a power of 10.
    * */
}
