import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	private final int x;
	private final int y;
	
    // Constructs the point (x, y)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
    // Draws this point
	public void draw() {
		StdDraw.point(x, y);
	}
	
    // Draws the line segment from this point to that point
	public void drawTo(Point that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
	
    // String representation
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	// Compare two points by y-coordinates, breaking ties by x-coordinates
	public int compareTo(Point that) {
		if (this.y < that.y)
			return -1;
		if (this.y > that.y)
			return 1;
		if (this.x < that.x)
			return -1;
		if (this.x > that.x)
			return 1;
		return 0;
	}
	
    // The slope between this point and that point
	public double slopeTo(Point that) {
		int diffY = this.y - that.y;
		int diffX = this.x - that.x;
		if (diffX == 0 && diffY == 0)
			return Double.NEGATIVE_INFINITY;
		if (diffX == 0)
			return Double.POSITIVE_INFINITY;
		if (diffY == 0)
			return 0.0;
		return (double) diffY / diffX;
	}
    
    // Compare two points by slopes they make with this point
	public Comparator<Point> slopeOrder() {
		return new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				double diffSlope = slopeTo(o1) - slopeTo(o2);
				if (diffSlope < 0) {
					return -1;
				} else if (diffSlope > 0) {
					return 1;
				}
				return 0;
			}
		};
	}


}
