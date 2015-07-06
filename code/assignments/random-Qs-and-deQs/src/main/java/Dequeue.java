public class Dequeue<Item> {

  Item[] s;
  int front;
  int back;

  public Dequeue() {
    s = (Item[]) new Object[5];
    front = 2;
    back = 2;
  }

  public boolean isEmpty() {
    if ((front == back) && (s[front] == null)) { return true; };
    return false;
  }

  public void addFirst(Item item) {
    if (front > (s.length / 2)) { resize(); }
    if (front == back) { back++; }
    s[++front] = item;
  }

  public Item removeFirst() {
    Item result = s[front--];
    if (front == back) { s[front] = null; }
    return result;
  }

  public void addLast(Item item) {
    if (back > (s.length / 2)) { resize(); }
    if (back == front) { front--; }
    s[--back] = item;
  }

  public Item removeLast() {
    Item result = s[back--];
    if (back == front) { s[back] = null; }
    return result;
  }

  private void resize() {
  }
}
