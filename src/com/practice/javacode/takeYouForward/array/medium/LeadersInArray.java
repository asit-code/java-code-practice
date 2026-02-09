package com.practice.javacode.takeYouForward.array.medium;

/*Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.*/

public class LeadersInArray {
    public static void main(String args[]) {
        int arr[] = {10, 22, 12, 3, 0, 6};
        findByOptimal(arr);
    }

    private static void findByOptimal(int[] arr) {
        int n = arr.length;
        int leader = arr[n - 1];
        System.out.print("Leader elements are: " + leader + " ");
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                System.out.print(arr[i] + " ");
                leader = arr[i];
            }
        }
    }
}
