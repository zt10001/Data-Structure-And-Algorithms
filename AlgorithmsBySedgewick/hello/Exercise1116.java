/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/24/22
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1116 {
    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }

    private static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
}
