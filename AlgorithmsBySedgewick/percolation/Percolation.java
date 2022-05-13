/* *****************************************************************************
 * Name:              Tao Zheng
 * Coursera User ID:  NA
 * Last modified:     04/03/2022
 *
 * Write a program to estimate the value of the *percolation threshold*
 * via Monte Carlo simulation.
 *
 * Percolation. Given a composite systems comprised of randomly distributed
 * insulating and metallic materials: what fraction of the materials need to
 * be metallic so that the composite system is an electrical conductor? Given
 * a porous landscape with water on the surface (or oil below),
 * under what conditions will the water be able to drain through to the bottom
 * (or the oil to gush through to the surface)? Scientists have defined an
 * abstract process known as percolation to model such situations.
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private final WeightedQuickUnionUF normalQU;
    private final WeightedQuickUnionUF backwashQU;
    private final boolean[] isOpen;
    private final int topIndex;
    private final int btmIndex;
    private final int n;
    private int openCount;

    /**
     * creates n-by-n grid, with all sites initially blocked
     * @param n length and width of the grid
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0!");
        }
        this.n = n;
        topIndex = 0;
        btmIndex = n * n + 1;
        backwashQU = new WeightedQuickUnionUF(n * n + 2);
        normalQU = new WeightedQuickUnionUF(n * n + 1); // without btmIndex
        isOpen = new boolean[n * n + 2];
        isOpen[topIndex] = true;
        isOpen[btmIndex] = true;
    }

    /**
     * Convert a 2D coordinate to 1D
     *
     * @param row
     * @param col
     */
    private int indexOf(int row, int col) {
        // check bounds
        if (row < 1 || row > n) {
            throw new IllegalArgumentException("Row is out of bounds.");
        }
        if (col < 1 || col > n) {
            throw new IllegalArgumentException("Column is out of bounds.");
        }
        return (row -1) * n + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int currIndex = indexOf(row, col);
        isOpen[currIndex] = true;
        openCount++;

        if (row == 1) {
            backwashQU.union(currIndex, topIndex);
            normalQU.union(currIndex, topIndex);
        }
        if (row == n) {
            backwashQU.union(currIndex, btmIndex);
        }

        tryUnion(row, col, row-1, col); // up
        tryUnion(row, col, row+1, col); // down
        tryUnion(row, col, row, col-1); // left
        tryUnion(row, col, row, col + 1); // right
    }

    private void tryUnion(int rowA, int colA, int rowB, int colB) {
        if (rowB > 0 && rowB <= n && colB > 0 && colB <= n
            && isOpen(rowB, colB)) {
            backwashQU.union(indexOf(rowA, colA), indexOf(rowB, colB));
            normalQU.union(indexOf(rowA, colA), indexOf(rowB, colB));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return isOpen[indexOf(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return (normalQU.find(topIndex) == normalQU.find(indexOf(row, col)));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return (backwashQU.find(topIndex) == backwashQU.find(btmIndex));
    }

    // test client (optional)
    public static void main(String[] args) {
        StdOut.println("Please run PercolationStats.java for test.");
    }
}
