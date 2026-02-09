package com.practice.javacode.takeYouForward.array.easy;

/*Given an array of integers, rotating array of elements by k elements either left or right.*/
public class RotateArrayByK {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Input array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int k = 2;
        rotateLeftByK(arr, arr.length, k);
        rotateRightByK(arr.length, k);
    }

    private static void rotateLeftByK(int[] arr, int n, int k) {
        byTempArray(arr, n, k);     // Tc = O(n), Sc = O(k)
        rotateLeftByReverse(n, k);  // Tc = O(n), Sc = O(1)
    }

    private static void rotateRightByK(int n, int k) {
        byTempArrayRight(n, k);     // Tc = O(n), Sc = O(k)
        rotateRightByReverse(n, k);
    }

    private static void byTempArray(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int temp[] = new int[k];

        for (int i = 0; i < k; i++) {       //Copy 1st k elements in temp arrays
            temp[i] = arr[i];
        }
        for (int i = k; i < n; i++) {       //shift last n-k elemeent by k position
            arr[i - k] = arr[i];
        }
        for (int i = n - k; i < n; i++) {   //copy the temp array element in last of array
            arr[i] = temp[i - n + k];
        }

        System.out.println("Rotate left by K using temp array: " + k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void byTempArrayRight(int n, int k) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];

        for (int i = n - k; i <= n - 1; i++) {
            temp[i - n + k] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
        System.out.println("\nRotate right by K using temp array: " + k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void rotateLeftByReverse(int n, int k) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);

        System.out.println("\nRotate left by K using array reversal: " + k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void rotateRightByReverse(int n, int k) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        k = k % n;
        reverseArray(arr, 0, n-1-k);
        reverseArray(arr, n-k, n-1);
        reverseArray(arr, 0, n-1);

        System.out.println("\nRotate right by K using array reversal: " + k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverseArray(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

}
