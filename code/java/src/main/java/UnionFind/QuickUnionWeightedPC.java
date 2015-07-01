package UnionFind;

public class QuickUnionWeightedPC {
  private int[] id;
  private int[] sz;

  public QuickUnionWeightedPC(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
    sz = new int[N];
  }

  public void union(int first, int second) {
    int first_root = root(first);
    int second_root = root(second);
    if (first_root == second_root) return;
    if (sz[first_root] > sz[second_root]) { id[second_root] = first_root; }
    else { id[first_root] = second_root; }
  }

  public boolean connected(int first, int second) {
    return root(first) == root(second);
  }

  private int root(int index) {
    if (id[index] == index) return index;
    id[index] = id[id[index]];
    return root(id[index]);
  }
}
