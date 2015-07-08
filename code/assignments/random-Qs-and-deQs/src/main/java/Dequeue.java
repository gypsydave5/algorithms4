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
    if (front == (s.length - 1)) { growFront(); }
    if (front <= (s.length / 4)) { shrinkFront(); }
    if ((front == back) && (s[front] == null)) { back++; }
    s[++front] = item;
  }

  private void shrinkFront() {
    Item[] newArray = (Item[]) new Object[s.length / 4];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = s[i];
    }
    s = newArray;
  }

  public Item removeFirst() {
    Item result = s[front--];
    if (front == back) { s[front] = null; }
    return result;
  }

  public void addLast(Item item) {
    if (back == 0) { growBack(); }
    if ((back == front) && (s[back] == null)) { front--; }
    s[--back] = item;
  }

  public Item removeLast() {
    Item result = s[back--];
    if (back == front) { s[back] = null; }
    return result;
  }

  private void growFront() {
    Item[] newArray = (Item[]) new Object[s.length * 2];
    for (int i = 0; i < s.length; i++) {
      newArray[i] = s[i];
    }
    s = newArray;
  }

  private void growBack() {
    Item[] newArray = (Item[]) new Object[s.length * 2];
    for (int i = 0; i < s.length; i++) {
      newArray[i + s.length] = s[i];
    }
    back = back + s.length;
    front = front + s.length;
    s = newArray;
  }
}
