package com.practice.javacode.arrayCode.search.easy;

public class SearchLargeThree {

    private static void print3Largest(int arr[]) {
        int i, a, b, c;
        if (arr.length < 3) {
            System.out.println("Invalid input");
            return;
        }
        a = b = c = Integer.MIN_VALUE;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > a) {
                c = b;
                b = a;
                a = arr[i];
            } else if (arr[i] > b) {
                c = b;
                b = arr[i];
            } else if (arr[i] > c) {
                c = arr[i];
            }
        }
        System.out.println("Three largest element are " + a + " ," + b + " ," + c + ".");
    }

    public static void main(String args[]) {
        int arr[] = {4, 5, 2, 34, 78, 35, 232, 23, 1, 7};
        print3Largest(arr);

    }
}
