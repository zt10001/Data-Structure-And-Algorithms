/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Email:             ztao10001@gmail.com
 *  Last modified:     6/20/22
 **************************************************************************** */

public class Exercise1112 {
    public static void main(String[] args) {

        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
