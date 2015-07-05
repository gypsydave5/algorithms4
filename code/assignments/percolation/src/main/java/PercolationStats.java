public class PercolationStats {

  private Percolation percolation;
  private double[] results;
  private int totalSites;

  public PercolationStats(int N, int T) {

    if (illegalArguments(N, T)) { throw new IllegalArgumentException(); }

    totalSites = N * N;
    results = new double[T];

    for (int i = 0; i < T; i++) {

      percolation = new Percolation(N);
      int openedSites = 0;

      while (!percolation.percolates()) {
        int x = StdRandom.uniform(1, N + 1);
        int y = StdRandom.uniform(1, N + 1);
        if (percolation.isFull(x, y)) {
          percolation.open(x, y);
          ++openedSites;
        }
      }
      int totalSites = N * N;
      double p = (double) openedSites / totalSites;
      results[i] = p;
    }
  }

  public double mean() {
    return StdStats.mean(results);
  }

  public double stddev() {
    return StdStats.stddev(results);
  }

  public double confidenceLo() {
    return StdStats.mean(results) -
            ((1.96 * StdStats.stddev(results)) / (Math.sqrt(totalSites)));
  }

  public double confidenceHi() {
    return StdStats.mean(results) +
            ((1.96 * StdStats.stddev(results)) / (Math.sqrt(totalSites)));
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      StdOut.print("PercolationStats <gridSize> <iterations>");
    } else {
      PercolationStats percStats = new PercolationStats(
              Integer.parseInt(args[0]), Integer.parseInt(args[1])
      );
      StdOut.println("mean                    = " + percStats.mean());
      StdOut.println("stddev                  = " + percStats.stddev());
      StdOut.println(
              "95% confidence interval = " +
                      percStats.confidenceLo() +
                      ", " +
                      percStats.confidenceHi()
      );
    }
  }

  private boolean illegalArguments(int N, int T) {
    return ((N < 1) || (T < 1));
  }
}
