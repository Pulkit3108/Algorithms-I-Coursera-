import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

	private final int trials;
	private double[] result;
	private boolean meanFlag = false;
	private double mean;
	private boolean stddevFlag = false;
	private double stddev;
	private final int N;
	
	
// Intiates several Percolation objects and, for each of them, opens sites randomly
	public PercolationStats(int N, int trials) {
		if (N <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		result = new double[trials];
		this.trials = trials;
		this.N = N;
	}
// Sample mean among the trials of the percolation threshold
	public double mean() {
		if (meanFlag) {
			return mean;
		}
		Percolation grid = null;
		for (int i = 0; i < trials; i++) {
			grid = new Percolation(N);
			while (!grid.percolates()) {
				grid.open(StdRandom.uniform(1, N + 1), StdRandom.uniform(1, N + 1));
			}
			result[i] = (double) grid.numberOfOpenSites() / (N * N);
		}
		mean = StdStats.mean(result);
		meanFlag = true;
		return mean;
	}

// Sample standard deviation of percolation threshold
	public double stddev() {
		mean();
		if (stddevFlag) {
			return stddev;
		} else {
			stddevFlag = true;
			stddev = StdStats.stddev(result);
			return stddev;
		}
	}

// Low endpoint of 95% confidence interval
	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(trials);
	}

// High endpoint of 95% confidence interval
	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(trials);
	}

	public static void main(String[] args) {
		PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("mean\t\t\t= " + stats.mean());
		System.out.println("stddev\t\t\t= " + stats.stddev());
		System.out.println("95% confidence interval\t= [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
	}
}
