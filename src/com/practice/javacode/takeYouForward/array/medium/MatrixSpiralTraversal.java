package com.practice.javacode.takeYouForward.array.medium;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralTraversal {
    public static void main(String args[]) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat); //Tc= n*m, Sc = n*mx

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }

    private static List<Integer> printSpiral(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
