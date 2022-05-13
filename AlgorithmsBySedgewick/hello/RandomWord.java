/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Coursera User ID:  NA
 *  Last modified:     April 2, 2022
 *
 *  Compilation: javac-algs4 RandomWord.java
 *  Execution:   java-algs4 RandomWord
 *
 *  Reads a sequence of words from standard input and prints one of those words
 *  uniformly at random. Do not store the words in an array or list.
 *  Instead, use Knuth’s method: when reading the ith word, select it with
 *  probability 1/i to be the champion, replacing the previous champion.
 *  After reading all of the words, print the surviving champion.
 *
 *  % java-algs4 RandomWord
 *  heads tails
 *  heads
 *
 *  % more animals8.txt
 *  ant bear cat dog
 *  emu fox goat horse
 *  % java-algs4 RandomWord < animals8.txt
 *  emu
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = "";

        for (int i = 1; !StdIn.isEmpty(); i++)  {
            String challenger = StdIn.readString();
            if (StdRandom.bernoulli((1.0/i))) {
                champ = challenger;
            }
        }

        StdOut.println(champ);
    }
}
