/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/20/22
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Exercise1113 {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6}
        };

        transposeArray(mat);
        StdOut.println("\nExpected:");
        StdOut.println("1 4 \n" +
                               "2 5 \n" +
                               "3 6 ");
    }

    private static void transposeArray(int[][] array) {

        int[][] newArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
            newArray[j][i] = array[i][j];
            }
        }

        print(newArray);
    }

    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                StdOut.print(array[i][j] + " ");
            }
            StdOut.println();
        }
    }
}
