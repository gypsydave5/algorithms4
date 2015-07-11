public class Percolation {

  private int[][] grid;
  private WeightedQuickUnionUF connections;
  private int size;
  private int top;
  private int[] bottoms;

  public Percolation(int N) {
    if (N < 1) { throw new IllegalArgumentException(); }
    grid = new int[N][N];
    size = (N * N) + 1 + N; //grid size plus the dummy top and bottoms
    bottoms = new int[N];
    top = 0;
    connections = new WeightedQuickUnionUF(size);

    if (N != 1) {
      for (int i = 0; i < N; i++) {
        connections.union(N - i, top);
        bottoms[i] = (N * N) + 1 + i;
        connections.union((N * N) - N + i + 1, bottoms[i]);
      }
    } else {
      bottoms[0] = 1;
    }
  }

  public void open(int i, int j) {
    grid[i - 1][j - 1] = 1;
    if (isInGrid(i, j - 1) && isOpen(i, j - 1)) {
      joinLeft(i, j);
    }
    if (isInGrid(i, j + 1) && isOpen(i, j + 1)) {
      joinRight(i, j);
    }
    if (isInGrid(i - 1, j) && isOpen(i - 1, j)) {
      joinUp(i, j);
    }
    if (isInGrid(i + 1, j) && isOpen(i + 1, j)) {
      joinDown(i, j);
    }
  }

  public boolean isOpen(int i, int j) {
    return grid[i - 1][j - 1] == 1;
  }

  public boolean isFull(int i, int j) {
    return (grid[i - 1][j - 1] == 1)
            && connections.connected(top, ((i - 1) * grid.length) + j);
  }

  public boolean percolates() {
    boolean result = false;
    for (int bottom : bottoms) {
      if (connections.connected(top, bottom)) { result = true; }
    }
    if ((grid.length == 1) && (isOpen(1, 1))) { result = true; }
    return result;
  }

  private boolean isInGrid(int i, int j) {
    return (0 < i)
            && (i <= grid.length)
            && (0 < j)
            && (j <= grid.length);
  }

  private void joinDown(int i, int j) {
    connections.union(((i - 1) * grid.length) + j, (i * grid.length) + j);
  }

  private void joinUp(int i, int j) {
    connections.union(((i - 1) * grid.length) + j, ((i - 2) * grid.length) + j);
  }

  private void joinRight(int i, int j) {
    connections.union(((i - 1) * grid.length) + j, (((i - 1) * grid.length) + j) + 1);
  }

  private void joinLeft(int i, int j) {
    connections.union(((i - 1) * grid.length) + j, (((i - 1) * grid.length) + j) - 1);
  }
}
