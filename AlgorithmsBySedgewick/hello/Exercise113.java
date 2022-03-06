/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Coursera User ID:  NA
 *  Last modified:     Feb 13, 2022
 *
 *  Write a program that takes three integer command-line arguments and prints
 *  `equal` if all three are equal, and `not equal` otherwise.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise113 {
    private static void isEqual(int n1, int n2, int n3) {
        if (n1 == n2 && n2 == n3) {
            StdOut.println("Equal");
        }
        else {
            StdOut.println("Not equal");
        }
    }

    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int n3 = Integer.parseInt(args[2]);

        isEqual(n1, n2, n3);
    }
}
