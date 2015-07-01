package UnionFindTests;

import UnionFind.*;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class UnionFindTest {
  @Test public void testQuickFind() {
    QuickFindUF qf = new QuickFindUF(20);
    qf.union(5, 10);
    qf.union(10, 6);
    qf.union(10, 7);
    assertTrue("should know when connected",
            qf.connected(6, 7)
    );
  }

  @Test public void testQuickUnion() {
    QuickUnionUFBroken qu = new QuickUnionUFBroken(20);
    qu.union(5, 10);
    qu.union(10, 6);
    qu.union(10, 7);
    assertTrue("should know when connected",
            qu.connected(6, 7)
    );
  }

  @Test public void testQuickUnionTwo() {
    QuickUnionUF qu = new QuickUnionUF(20);
    qu.union(5, 10);
    qu.union(10, 6);
    qu.union(10, 7);
    assertTrue("should know when connected",
            qu.connected(6, 7)
    );
  }

  @Test public void testQuickUnionWeighted() {
    QuickUnionWeighted qu = new QuickUnionWeighted(20);
    qu.union(5, 10);
    qu.union(10, 6);
    qu.union(10, 7);
    assertTrue("should know when connected",
            qu.connected(6, 7)
    );
  }

  @Test public void testQuickUnionWeightedPC() {
    QuickUnionWeightedPC qu = new QuickUnionWeightedPC(20);
    qu.union(5, 10);
    qu.union(10, 6);
    qu.union(10, 7);
    assertTrue("should know when connected",
            qu.connected(6, 7)
    );
  }
}
