package com.practice.javacode.arrayCode.search.easy;

public class FindRepeatAndMissing {

    private static void searchByBitMethod(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            xor = xor ^ (i + 1);
        }
        int setbit = xor & ~(xor - 1);  ///see note
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if ((setbit & arr[i]) != 0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
            if ((setbit & (i + 1)) != 0)
                x = x ^ (i + 1);
            else
                y = y ^ (i + 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                count++;
        }
        if (count == 2) {
            System.out.println("Repeat: " + x + " Missing: " + y);
        } else {
            System.out.println("Repeat: " + y + " Missing: " + x);
        }
    }

    private static void searchByCountArray(int[] arr, int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[arr[i] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0)
                System.out.println("Missing no is: " + (i + 1));
            if (temp[i] > 1)
                System.out.println("Repeat no is: " + (i + 1));
        }
    }

    private static void searchByNegativeMarking(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(arr[i]); //it will convert -ve to ve.
            if (arr[abs - 1] > 0)   // check while marking negative
                arr[abs - 1] = -arr[abs - 1];
            else
                System.out.println("Repeat no is: " + abs);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                System.out.println("Missing no is: " + (i + 1));
        }

    }


    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 5, 6, 2};
        System.out.println("Search by using bit manupulation.");
        searchByBitMethod(arr, arr.length); // T = O(n), S = O(1)

        System.out.println("Search by counting the array element in new array");
        searchByCountArray(arr, arr.length); // T = O(n), S = O(n)

        System.out.println("Search by marking visited element as -ve");
        searchByNegativeMarking(arr, arr.length); // T = O(n), S = O(1)
    }





    /*
    bit manipulation:
    *****In the result xor1, all elements would nullify each other except x and y. All the bits that are set in xor1 will be set in either x or y. So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and divide the elements of the array in two sets – one set of elements with the same bit set and another set with the same bit not set. By doing so, we will get x in one set and y in another set. Now if we do XOR of all the elements in the first set, we will get x, and by doing the same in the other set we will get y.
    *
    * Logic to get right most setbit number.
        int setbit = xor & ~(xor - 1);
        * or
        int setbit = 0;
        while(true){
            if((xor & (1<<setbit)) != 0)
                break;
            setbit++;
        }
    * Logic to test the array element as same bit ot not
    * if((arr[i] & (1<< setbit) !=0) ---> same bit
    or
    * if ((arr[i] & setbit) != 0)
    * */
}
