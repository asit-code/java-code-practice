package com.practice.javacode.takeYouForward.array.easy;

/* You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order. */
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 0, 2, 0, 3, 0};
        usingTwoPointerInOrder(arr);
        //usingTwoPointerInOrder2(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void usingTwoPointerInOrder(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {  // j = 1st zero
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return;
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }

    private static void usingTwoPointerInOrder2(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 0) {
                int j = i + 1;
                while (j < n - 1 && arr[j] == 0) {
                    j++;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
