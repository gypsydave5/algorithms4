package UnionFind;

public class QuickFindUF {

  private int[] id;

  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int first, int second) {
    return id[first] == id[second];
  }

  public void union(int first, int second) {
    int firstId = id[first];
    int secondId = id[second];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == firstId) id[i] = secondId;
    }
  }
}
