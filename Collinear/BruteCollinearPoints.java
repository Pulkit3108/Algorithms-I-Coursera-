import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private int numSegments;
    private LineSegment[] lineSegments;
	
    // Finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        validateInput(points);

        numSegments = 0;
        lineSegments = new LineSegment[points.length];

        for (int i = 0; i < points.length; i++)
            for (int j = i+1; j < points.length; j++)
                for (int k = j+1; k < points.length; k++) {
                    Point p = points[i];
                    Point q = points[j];
                    Point r = points[k];

                    if (areCollinear(p, q, r))
                        for (int t = k+1; t < points.length; t++) {
                            Point s = points[t];
                            if (areCollinear(p, q, s)) addSegment(p, q, r, s);
                        }
                }

    }
	// The number of line segments
    public int numberOfSegments() { 
	    return numSegments; 
	}
	// The line segments
    public LineSegment[] segments() {
        return Arrays.copyOfRange(lineSegments, 0, numberOfSegments());
    }

    private void addSegment(Point p, Point q, Point r, Point s) {
        Point[] collinearPoints = {p, q, r, s};
        Arrays.sort(collinearPoints);
        Point minPoint = collinearPoints[0];
        Point maxPoint = collinearPoints[3];

        lineSegments[numSegments++] = new LineSegment(minPoint, maxPoint);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
        }
    }

    private void validateInput(Point[] points) {
        if (points == null) throw new IllegalArgumentException("The input argument is null");
        for (Point point : points) if (point == null) throw new IllegalArgumentException("The input contains null points");

        for (int i = 0; i < points.length; i++)
            for (int j = i+1; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException("The input contains repeated points");

    }

    private boolean areCollinear(Point p1, Point p2, Point p3) {
        return (Double.compare(p1.slopeTo(p2), p1.slopeTo(p3)) == 0);
    }
}
