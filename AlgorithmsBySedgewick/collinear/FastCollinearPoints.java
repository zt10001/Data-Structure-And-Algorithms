/* *****************************************************************************
 *  Name: Tao Zheng
 *  Date: 2022-05-12
 *  Description:
 **************************************************************************** */

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

            }
        }
    }

    public void checkNull(Point[] points) {

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

    public static void main(String[] args) {

    }
}
