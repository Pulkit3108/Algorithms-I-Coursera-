public class LineSegment {
	// One endpoint of this line segment
	private final Point p; 
	
	// The other endpoint of this line segment
	private final Point q;
	
    // Constructs the line segment between points p and q
	public LineSegment(Point p, Point q) {
		if (p == null || q == null) {
			throw new NullPointerException("argument is null");
		}
		this.p = p;
		this.q = q;
	}

	// Draws this line segment
	public void draw() {
		p.drawTo(q);
	}

	
	// String representation
    public String toString() {
		return p + " -> " + q;
	}

	public int hashCode() {
		throw new UnsupportedOperationException();
	}

}
