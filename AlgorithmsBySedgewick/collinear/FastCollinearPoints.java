/* *****************************************************************************
 *  Name: Tao Zheng
 *  Date: 2022-05-12
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {

    private final LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points) {

        checkNull(points);
        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);
        checkDuplicate(sortedPoints);

        final int N = points.length;
        final List<LineSegment> maxLineSegments = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            Point p = sortedPoints[i];
            Point[] pointsBySlope = sortedPoints.clone();
            Arrays.sort(pointsBySlope, p.slopeOrder());

            int x = 1;
            while (x < N) {

                LinkedList<Point> candidates = new LinkedList<>();
                final double SLOPE_REF = p.slopeTo(pointsBySlope[x]);
                do {
                    candidates.add(pointsBySlope[x++]);
                } while (x < N && p.slopeTo(pointsBySlope[x]) == SLOPE_REF);

                if (candidates.size() >= 3
                    && p.compareTo(candidates.peek()) < 0) {
                    Point max = candidates.removeLast();
                    maxLineSegments.add(new LineSegment(p, max));
                }
            }
        }
        lineSegments = maxLineSegments.toArray(new LineSegment[0]);
    }

    private void checkNull(Point[] points) {

        if (points == null) {
            throw new IllegalArgumentException("The array \"points\" is null.");
        }

        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException(
                        "The array \"points\" contains null element.");
            }
        }

    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < (points.length) - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate found.");
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments.clone();
    }
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
