import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnionFindTest {
  @Test public void testQuickFind() {
    QuickFindUF qf = new QuickFindUF(20);
    qf.union(5, 10);
    assertTrue("should know when connected",
            qf.connected(5, 10)
    );
  }

  @Test public void testQuickUnion() {
    QuickUnionUF qu = new QuickUnionUF(20);
    qu.union(5, 10);
    assertTrue("should know when connected",
            qu.connected(5, 10)
    );
  }
}
