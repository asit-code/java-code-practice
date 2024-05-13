package com.practice.javacode.arrayCode.search;

public class InterpolationSearch {

    private static int interpolationSearch(int[] A, int lo, int hi, int x) {

        while (lo <= hi && x >= A[lo] && x <= A[hi]) {

            if (lo == hi) {
                if (A[lo] == x)
                    return lo;
                return -1;
            }
            int pos = lo + ((x - A[lo]) * ((hi - lo) / (A[hi] - A[lo])));

            if (x == A[pos]) {
                return pos;
            } else if (x < A[pos]) {
                hi = pos - 1;
            } else {
                lo = pos + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47};

        int n = arr.length;

        // Element to be searched
        int x = 18;
        int index = interpolationSearch(arr, 0, n - 1, x);
        System.out.println("index: " + index);
    }

}

/*
 * Uniformly distributed sorted array.
 * interpolation search may go to different locations according to the value of the key being searched. For example, if the value of the key is closer to the last element, interpolation search is likely to start search toward the end side.
 *
 * pos = lo + (x - arr[lo] ) * (hi-lo)/(arr[hi]-arr[lo])
 *
 * */

