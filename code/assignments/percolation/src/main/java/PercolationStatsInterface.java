public interface PercolationStatsInterface {
  double mean();                      // sample mean of percolation threshold
  double stddev();                    // sample standard deviation of percolation threshold
  double confidenceLo();              // low  endpoint of 95% confidence interval
  double confidenceHi();              // high endpoint of 95% confidence interval
}
