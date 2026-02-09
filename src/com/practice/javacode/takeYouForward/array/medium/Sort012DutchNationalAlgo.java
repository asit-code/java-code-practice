package com.practice.javacode.takeYouForward.array.medium;

public class Sort012DutchNationalAlgo {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortByCounter(arr);//  Tc = O(2N), Sc = O(1)

        int[] arr1 = {2, 0, 2, 1, 1, 0};
        // Dutch national flag algo.
        sortByThreePointer(arr1);// Tc = O(N), Sc = O(1)
    }

    private static void sortByCounter(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count0++;
            if (arr[i] == 1)
                count1++;
            if (arr[i] == 2)
                count2++;
        }
        int j = 0;
        for (int i = 0; i < count0; i++, j++) {
            arr[j] = 0;
        }
        for (int i = 0; i < count1; i++, j++) {
            arr[j] = 1;
        }
        for (int i = 0; i < count2; i++, j++) {
            arr[j] = 2;
        }
        System.out.println("Sorted array by 3 counter: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortByThreePointer(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid < high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
        System.out.println();
        System.out.println("Sorted array by 3 pointer: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
