public class Dequeue<Item> {

  Item[] s;
  int front;
  int back;

  public Dequeue() {
    s = (Item[]) new Object[10];
    front = 5;
    back = 6;
  }

  public boolean isEmpty() {
    if (front < back) { return true; };
    return false;
  }

  public void addFirst(Item item) {
    if (front == (s.length - 1)) { growFront(); }
    s[++front] = item;
  }

  public Item removeFirst() {
    if (isEmpty()) { return null; }
    Item result = s[front--];
    if (front < (s.length / 4)) { shrinkFront(); }
    return result;
  }

  public void addLast(Item item) {
    if (back == 0) { growBack(); }
    s[--back] = item;
  }

  public Item removeLast() {
    if (isEmpty()) { return null; }
    Item result = s[back++];
    if (back > ((s.length / 4) * 3)) { shrinkBack(); }
    return result;
  }

  private void shrinkFront() {
    StdOut.println("Shrinking Front!!!");
    Item[] newArray = (Item[]) new Object[s.length / 2];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = s[i];
    }
    s = newArray;
  }

  private void shrinkBack() {
    StdOut.println("Shrinking Back!!!");
    Item[] newArray = (Item[]) new Object[s.length / 2];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = s[i + (newArray.length)];
    }
    front = front - newArray.length;
    back = back - newArray.length;
    s = newArray;
  }

  private void growFront() {
    StdOut.println("Growing Front!!!");
    Item[] newArray = (Item[]) new Object[s.length * 2];
    for (int i = 0; i < s.length; i++) {
      newArray[i] = s[i];
    }
    s = newArray;
  }

  private void growBack() {
    StdOut.println("Growing Back!!!");
    Item[] newArray = (Item[]) new Object[s.length * 2];
    for (int i = 0; i < s.length; i++) {
      newArray[i + s.length] = s[i];
    }
    back = back + s.length;
    front = front + s.length;
    s = newArray;
  }
}
