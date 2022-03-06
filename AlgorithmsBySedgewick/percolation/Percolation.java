/* *****************************************************************************
 *  Name:              Tao Zheng
 *  Coursera User ID:  NA
 *  Last modified:     01/05/2022
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF wqfGrid;
    private WeightedQuickUnionUF wqfFull;
    private int gridSideSize;
    private int gridSquaredSize;
    private int virtualTop;
    private int virtualBottom;
    private int openSites;

    private int flattenGrid(int row, int col) {
        return gridSideSize * (row -1) + col;
    }

    private boolean isOnGrid(int row, int col) {
        int indexRow = row - 1;
        int indexCol = col - 1;
        return (indexRow >= 0
                && indexCol >=0
                && indexRow < gridSideSize
                && indexCol < gridSideSize);
    }

    private void validateSite(int row, int col) {
        if (!isOnGrid(row, col)) {
            throw new IllegalArgumentException("Site is out of grid");
        }
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        gridSideSize = n;
        gridSquaredSize = n * n;
        grid = new boolean[gridSideSize][gridSideSize];
        // includes virtual top and bottom in weighted quick union grid
        wqfGrid = new WeightedQuickUnionUF(gridSquaredSize + 2);
        // includes virtual top in weighted quick union grid
        wqfFull = new WeightedQuickUnionUF(gridSquaredSize + 1);
        virtualBottom = gridSquaredSize + 1;
        virtualTop = gridSquaredSize;
        openSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateSite(row, col);

        int indexRow = row - 1;
        int indexCol = col - 1;
        int flatIndex = flattenGrid(row, col) - 1;

        // if already open, stop
        if (isOpen(row, col)) {
            return;
        }

        // open site
        grid[indexRow][indexCol] = true;
        openSites++;

        if (row == 1) { // connect sites at top row to virtual top
            wqfGrid.union(virtualTop, flatIndex);
            wqfFull.union(virtualTop, flatIndex);
        }

        if (row == gridSideSize) { // connect sites at bottom row to virtual bottom
            wqfGrid.union(virtualBottom, flatIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateSite(row, col);
        return grid[row-1][col-1];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    // returns the number of open sites
    public int numberOfOpenSites()
    // does the system percolate?
    public boolean percolates()
    // test client (optional)
    public static void main(String[] args) {

    }
}
