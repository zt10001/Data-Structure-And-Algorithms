/* *****************************************************************************
 * Name:              Tao Zheng
 * Coursera User ID:  NA
 * Last modified:     4/10/22
 *
 * Monte Carlo simulation: perform a series of computational experiment to
 * estimate the percolation threshold.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] openFractions;
    private final double CONFIDENCE_95 = 1.96; // Should it also be static?

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) {
            throw new IllegalArgumentException("n needs to be greater than 0.");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("trials needs to be greater than 0.");
        }
        openFractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
            }
            int openSites = percolation.numberOfOpenSites();
            openFractions[i] = openSites * 1.0 / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openFractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openFractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(openFractions.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(openFractions.length);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt((args[1]));
        PercolationStats stats = new PercolationStats(n, trials);

        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = ["
                        + stats.confidenceLo() + ", "
                        + stats.confidenceHi() + "]");
    }
}
