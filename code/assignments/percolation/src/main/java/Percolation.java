public class Percolation {

  int[][] grid;
  int[] connections;
  int[] size;
  int top;
  int bottom;

  public Percolation(int N) {
    if (N < 0) { throw new IllegalArgumentException(); }
    grid = new int[N][N];
    connections = new int[(N * N) + 2];
    size = new int[N * N + 2];
    bottom = (N * N + 1);
    top = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) { grid[i][j] = 0; }
    }

    for (int i = 1; i < connections.length; i++) { connections[i] = i; }

    for (int i = 0; i < N; i++) {
      join(N - i, top);
      join((N * N) - N + i + 1, bottom);
    }
  }

  public void open(int i, int j) {
    grid[i - 1][j - 1] = 1;
    if (inBounds(i, j - 1) && isOpen(i, j - 1)) {
      joinBelow(i, j);
    }
    if (inBounds(i, j + 1) && isOpen(i, j + 1)) {
      joinAbove(i, j);
    }
    if (inBounds(i - 1, j) && isOpen(i - 1, j)) {
      joinLeft(i, j);
    }
    if (inBounds(i + 1, j) && isOpen(i + 1, j)) {
      joinRight(i, j);
    }
  }


  private boolean inBounds(int i, int j) {
    return (0 < i) &&
            (i <= grid.length) &&
            (0 < j) &&
            (j <= grid.length);
  }

  public boolean isOpen(int i, int j) {
    return grid[i - 1][j - 1] == 1;
  }

  public boolean isFull(int i, int j) {
    return grid[i - 1][j - 1] == 0;
  }

  public boolean percolates() {
    return connected(top, bottom);
  }

  private void join(int first, int second) {
    int first_root = root(first);
    int second_root = root(second);
    if (first_root == second_root) return;
    if (size[first_root] > size[second_root]) {
      connections[second_root] = first_root;
      size[first_root]++;
    }
    else {
      connections[first_root] = second_root;
      size[second_root]++;
    }
  }

  private int root(int index) {
    if (connections[index] == index) return index;
    connections[index] = connections[connections[index]];
    return root(connections[index]);
  }

  private boolean connected(int first, int second) {
    return root(first) == root(second);
  }

  private void joinRight(int i, int j) {
    join(((j - 1) * grid.length) + i, ((j - 1) * grid.length) + i + 1);
  }

  private void joinLeft(int i, int j) {
    join(((j - 1) * grid.length) + i, ((j - 1) * grid.length) + i - 1);
  }

  private void joinAbove(int i, int j) {
    join(((j - 1) * grid.length) + i, (j * grid.length) + i);
  }

  private void joinBelow(int i, int j) {
    join(((j - 1) * grid.length) + i, ((j - 2) * grid.length) + i);
  }
}
