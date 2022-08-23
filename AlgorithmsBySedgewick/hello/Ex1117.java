/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/24/22
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Ex1117 {
    public static void main(String[] args) {
        StdOut.println(exR2(3));
    }
    private static String exR2(int n)
    {
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if (n <= 0) return "";
        return s;
    }
}
