package com.practice.javacode.takeYouForward.array.easy;

public class MaxConsicutiveOnes {
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 1, 1};

        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > max)
                max = count;
        }
        System.out.println("Max consicutive 1s' in the array is: " + max);
    }
}
