/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/22/22
 *
 *  Write a static method lg() that takes an int value N as argument and returns
 *  the largest int not larger than the base-2 logarithm of N. Do not use Math.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1114 {
    public static void main(String[] args) {
        StdOut.print(log2(130));
        StdOut.println("\nExpected: 7");
    }

    private static int log2(int n) {

        int log2Int = 0;

        while (n > 1) {
            log2Int++;
            n /=2;
        }

        return log2Int;
    }
}
