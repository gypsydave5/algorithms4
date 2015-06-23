public class QuickUnionUF {

  private int[] id;

  public QuickUnionUF(int N) {
   id = new int[N];
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
