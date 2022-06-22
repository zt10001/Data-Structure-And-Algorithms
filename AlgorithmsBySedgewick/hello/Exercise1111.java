/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/20/22
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1111 {

    public static void main(String[] args) {
        boolean[][] array = {{true, false, true},
                             {false, true, false}};
        print2DBoolArray(array);
    }

    private static void print2DBoolArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == true) StdOut.print("*");
                else                     StdOut.print(" ");
            }
            StdOut.println();
        }
    }
}
