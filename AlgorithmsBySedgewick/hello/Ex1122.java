/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/26/22
 *  Write a version of BinarySearch that uses the recursive rank() given on page
 *  25 and traces the method calls. Each time the recursive method is called,
 *  print the argument values lo and hi, indented by the depth of the recursion.
 *  Hint: Add an argument to the recursive method that keeps track of the depth.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex1122 {
    public static void main(String[] args) {
        int arr[] = {5, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int key = 5;

        Arrays.sort(arr);

        int index = rank(key, arr, 2, arr.length-1, 0);

        StdOut.println();
        StdOut.println("Index: " + index);

        StdOut.println("\nExpected:");
        StdOut.println("lo: 0 - hi: 6\n" +
                               " lo: 0 - hi: 2\n" +
                               "Index: 1");
    }

    private static int rank(int key, int[] arr, int lo, int hi, int depth) {

        if (depth != 0) {
            StdOut.println();
        }

        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }

        StdOut.print("lo: " + lo + " - hi: " + hi);

        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                return rank(key, arr, lo, mid-1, ++depth);
            } else if (key > arr[mid]) {
                return rank(key, arr, mid+1, hi, ++depth);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
