package com.practice.javacode.takeYouForward.array.easy;

/*
Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
*/
public class FindMissingNumber {

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 6, 4};
        int n = 6;
        findByHashing(arr, n); // Tc = O(N), Sc = O(N)
        findByXOR(arr, n); // Tc = O(N), Sc = O(1)
    }

    private static void findByHashing(int[] arr, int n) {
        int[] hs = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            hs[arr[i]] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (hs[i] == 0) {
                System.out.println("The missing number by hahing is: " + i);
                return;
            }
        }
    }

    private static void findByXOR(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ (i + 1);            // XOR of 1...n-1
            xor2 = xor2 ^ arr[i];           // XOR of array elements
        }
        xor1 = xor1 ^ n;
        System.out.println("The Missing element by XOR is: " + (xor1 ^ xor2));
    }
}
