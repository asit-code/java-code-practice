package com.practice.javacode.takeYouForward.array.medium;

public class MatrixReverseBy90 {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = arr.length;
        int m = arr[0].length;
        int rotated[][] = rotatebyBF(arr, n, m); // Tc =n*m, Sc = n*m
        int rotated2[][] = rotateInSameMatrix(arr, n, m); // Tc =n*m + n*m ~ n*m, Sc = 0


        System.out.println("Rotated Image");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(rotated2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotatebyBF(int[][] arr, int n, int m) {
        int rotated[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    private static int[][] rotateInSameMatrix(int[][] arr, int n, int m) {
        //Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        //reverse each row
        for (int i =0; i<n; i++){
            for (int j =0; j<m/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][m-1-j];
                arr[i][m-1-j] = temp;
            }
        }
        return arr;
    }
}
