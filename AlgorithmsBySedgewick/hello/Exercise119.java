/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/20/22
 *  Write a code fragment that puts the binary representation of a positive
 *  integer N into a String s.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise119 {
    public static void main(String[] args) {
        StdOut.println(intToBinary(32));
        StdOut.println("Expected: 100000");
    }

    private static String intToBinary(int n) {
        String s = "";

        while (n > 0) {
            s = String.valueOf(n % 2) + s;
            n /= 2;
        }

        return s;
    }
}
