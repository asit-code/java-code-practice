package com.practice.javacode.takeYouForward.array.easy;

public class aaFindSecondSmallestLargestInArray {
    public static void main(String args[]) {
        int arr[] = {2, 5, 3, 5, 1, 7, 9, 4, 9, 1};
        findSecondSmallestLargestElement(arr);
        // Tc = O(N), Sc = O(1)
    }

    private static void findSecondSmallestLargestElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                second_min = min;
                min = arr[i];
            } else if (arr[i] < second_min && arr[i] != min) {
                second_min = arr[i];
            }
            if (arr[i] > max) {
                second_max = max;
                max = arr[i];

            } else if (arr[i] > second_max && arr[i] != max) {
                second_max = arr[i];
            }
        }
        System.out.println("min: " + min + ", second min; " + second_min + ", max: " + max + ", second max: " + second_max);
    }
}
