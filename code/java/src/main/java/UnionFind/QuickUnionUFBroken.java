package UnionFind;

public class QuickUnionUFBroken {

  private int[] id;

  public QuickUnionUFBroken(int N) {
   id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public void union(int first, int second) {
    id[first] = id[second];
  }

  public boolean connected(int first, int second) {
    return root(first) == root(second);
  }

  private int root(int index) {
    if (id[index] == index) return index;
    return root(id[index]);
  }
}
