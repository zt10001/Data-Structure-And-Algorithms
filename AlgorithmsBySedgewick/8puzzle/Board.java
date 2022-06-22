/* *****************************************************************************
 *  Name: Tao Zheng
 *  Date: 2022-05-14
 *  Description:
 **************************************************************************** */

public class Board {

    private final int[][] tiles;
    private final int n;
    private int blankRow;
    private int blankCol;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {

        if (tiles == null) {
            throw new IllegalArgumentException("Tiles cannot be null.");
        }

        this.tiles = copyOf(tiles);
        n = tiles.length;
        blankRow = -1;
        blankCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (tiles[row][col] == 0) {
                    blankRow = row;
                    blankCol = col;
                    return;
                }
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(n).append("\n");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                builder.append(String.format("%2d ", tiles[row][col]));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int distance = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == blankRow && col == blankCol) {
                    continue;
                }
                if (manhattan(row, col) != 0) {
                    distance++;
                }
            }
        }
        return distance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == blankRow && col == blankCol) {
                    continue;
                }
                distance += manhattan(row, col);
            }
        }
        return distance;
    }

    private int manhattan(int row, int col) {
        int destVal = tiles[row][col] - 1;
        int destRow = destVal / n;
    }
    // is this board the goal board?
    public boolean isGoal()

    // does this board equal y?
    public boolean equals(Object y)

    // all neighboring boards
    public Iterable<Board> neighbors()

    // a board that is obtained by exchanging any pair of tiles
    public Board twin()

    // unit testing (not graded)
    public static void main(String[] args)

}
