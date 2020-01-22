import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {

	private final boolean[][] map;
	private final WeightedQuickUnionUF grid;
	private final WeightedQuickUnionUF gridWithoutBottom;
	private int closedSites;
	private final int N;

// Creates an n-by-n grid, with all sites initially blocked
	public Percolation(int N) {	
		if (N <= 0) {
			throw new IllegalArgumentException();
		}
		map = new boolean[N][N];
		closedSites = N * N;
		this.N = N;
		grid = new WeightedQuickUnionUF(N * N + 2);
		gridWithoutBottom = new WeightedQuickUnionUF(N * N + 1);
	}
// Opens the site (row, col) if it's not already open
	public void open(int row, int col) {
		if (row < 1 || row > N || col < 1 || col > N) {
			throw new IllegalArgumentException();
		}
		if (isOpen(row, col)) {
			return;
		}
		map[row - 1][col - 1] = true;
		closedSites--;
		if (row - 1 > 0 && isOpen(row - 1, col)) {
			grid.union(map(row, col), map(row - 1, col));
			gridWithoutBottom.union(map(row, col), map(row - 1, col));
		}
		if (row + 1 <= N && isOpen(row + 1, col)) {
			grid.union(map(row, col), map(row + 1, col));
			gridWithoutBottom.union(map(row, col), map(row + 1, col));
		}
		if (col - 1 > 0 && isOpen(row, col - 1)) {
			grid.union(map(row, col), map(row, col - 1));
			gridWithoutBottom.union(map(row, col), map(row, col - 1));
		}
		if (col + 1 <= N && isOpen(row, col + 1)) {
			grid.union(map(row, col), map(row, col + 1));
			gridWithoutBottom.union(map(row, col), map(row, col + 1));
		}
		if (row == 1) {
			grid.union(0, map(row, col));
			gridWithoutBottom.union(0, map(row, col));
		}
		if (row == N) {
			grid.union(N * N + 1, map(row, col));
		}
	}
// Indicates if a specific site is open or not
	public boolean isOpen(int row, int col) {
		if (row < 1 || row > N || col < 1 || col > N) {
			throw new IllegalArgumentException();
		}
		return map[row - 1][col - 1];
	}

// Indicates if the specified site is connected to any site in the top row of the grid
	public boolean isFull(int row, int col) {
		if (row < 1 || row > N || col < 1 || col > N) {
			throw new IllegalArgumentException();
		}
		return gridWithoutBottom.connected(0, map(row, col));
	}
// Indicates how many sites are open in the grid
	public int numberOfOpenSites() {
		return N * N - closedSites;
	}

// Indicates if the grid percolates (i.e. if any site at the top row is connected to any site)
	public boolean percolates() {
		return grid.connected(0, N * N + 1);
	}

	private int map(int row, int col) {
		return (row - 1) * N + col;
	}
}
