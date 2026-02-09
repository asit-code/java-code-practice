package com.practice.javacode.takeYouForward.array.medium;

/*Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.*/

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSetToZero {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        //ArrayList<ArrayList<Integer>> result = findByBF(matrix, n, m); // Tc = O((N*M)*(N + M)) + O(N*M), Sc = O(1)
        //ArrayList<ArrayList<Integer>> result2 = findByTwoArray(matrix, n, m); // Tc = O(2(N*M), Sc = O(n+m)
        ArrayList<ArrayList<Integer>> result3 = findByInclusiveTwoArray(matrix, n, m); // Tc = O(2(N*M), Sc = O(1)


        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : result3) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    private static ArrayList<ArrayList<Integer>> findByBF(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, i, m);
                    markColumn(matrix, n, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    private static void markRow(ArrayList<ArrayList<Integer>> matrix, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0)
                matrix.get(i).set(j, -1);
        }
    }

    private static void markColumn(ArrayList<ArrayList<Integer>> matrix, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findByTwoArray(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> findByInclusiveTwoArray(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int c0 = 1;
        // step 1: Traverse the matrix and mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    if (j == 0) {
                        c0 = 0;
                    } else {
                        matrix.get(0).set(j, 0);
                    }
                }
            }
        }
        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }
        //step 3: Finally mark the first 1st row & then 1st col:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (c0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }
}
