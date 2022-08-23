/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/26/22
 *  1.1.20 Write a recursive static method that computes the value of ln (N !)
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Ex1120 {
    public static void main(String[] args) {
        StdOut.println("ln(5!) = " + lnFactorial(5));
        StdOut.println("Expected: 4.787491742782046");
    }

    private static double lnFactorial(int N) {
        if (N == 1) {
            return 0;
        }
        return Math.log(N) + lnFactorial(N-1);
    }
}
