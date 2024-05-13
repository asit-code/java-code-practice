package com.practice.javacode.arrayCode.search;

/*observation:
 * F(n - 2) ≈ (1/3)*F(n) and
 * F(n - 1) ≈ (2/3)*F(n)
 * */
public class FibonacciSearch {

    public static int fibonacciMethod(int[] arr, int n, int x) {
        if (arr[0] == x)
            return x;

        int fbm2 = 0;
        int fbm1 = 1;
        int fb = fbm2 + fbm1;

        while (fb <= n) {
            fbm2 = fbm1;
            fbm1 = fb;
            fb = fbm1 + fbm2;
        }

        int offset = -1;

        /* while there are elements to be inspected. Note that we compare arr[fbMm2] with x. When fibM becomes 1, fibMm2 becomes 0 */
        while (fb > 1) {
            int i = Math.min(offset + fbm2, n - 1);
            if (x > arr[i]) {
                offset = i;
                fb = fbm1;
                fbm1 = fbm2;
                fbm2 = fb - fbm1;
            } else if (x < arr[i]) {
                fb = fbm2;
                fbm1 = fbm1 - fbm2;
                fbm2 = fb - fbm1;
            } else
                return i;  // x = arr[i] -- element found
        }
        if (fbm1 == 1 && arr[n - 1] == x) {
            return n - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100, 235};
        int n = 12;
        int x = 235;
        int result = fibonacciMethod(arr, n, x);
        System.out.println("Index: " + result);
    }
}



/*
1. Find the smallest Fibonacci Number greater than or equal to n. Let this number be fibM [m’th Fibonacci Number]. Let the two Fibonacci numbers preceding it be fibMm1 [(m-1)’th Fibonacci Number] and fibMm2 [(m-2)’th Fibonacci Number].
2. While the array has elements to be inspected:
    1. Compare x with the last element of the range covered by fibMm2
    2. If x matches, return index
    3. Else If x is less than the element, move the three Fibonacci variables two Fibonacci down, indicating elimination of approximately rear two-third of the remaining array.
    4. Else x is greater than the element, move the three Fibonacci variables one Fibonacci down. Reset offset to index. Together these indicate the elimination of approximately front one-third of the remaining array.
3. Since there might be a single element remaining for comparison, check if fibMm1 is 1. If Yes, compare x with that remaining element. If match, return index.
---------------
1. find F(K) which is >= n
2. If F(K) == 0, stop print element not found.
3. offset = -1
4. i = min(offset + F(k-2), n-1)
5. If S == A[i]
        return i and stop search
   If S > A[i]
        k = k-1, offset = i and repeat step 4, 5
   If S < A[i]
        k = k-2 and repeat 4, 5

*/

