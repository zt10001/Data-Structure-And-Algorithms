/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Coursera User ID:  NA
 *  Last modified:     March 31, 2022
 *
 *  Compilation: javac HelloGoodbye.java
 *  Execution:   java HelloGoodbye
 *
 *  Takes two names as command-line arguments and prints hello and goodbye
 *  messages as shown below (with the names for the hello message in the same
 *  order as the command-line arguments and with the names for the goodbye
 *  message in reverse order)
 *
 *  % java HelloGoodbye Kevin Bob
 *  Hello Kevin and Bob.
 *  Goodbye Bob and Kevin.
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
