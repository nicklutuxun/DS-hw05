package hw5;

/**
 * Set implemented using a doubly linked list and move-to-front heuristic.
 *
 * @param <T> Element type.
 */
public class MoveToFrontLinkedSet<T> extends LinkedSet<T> {
  
  /**
   * Main function used in hacking linear search.
   * @param args NA
   */
  public static void main(String[] args) {
    MoveToFrontLinkedSet<Integer> linkedSet = new MoveToFrontLinkedSet<>();
    for (int i = 0; i < 10; i++) {
      linkedSet.insert(i);
    }
    for (int i = 0; i < 10; i = i + 2) {
      linkedSet.has(i);
    }
    for (int i = 0; i < 10; i = i + 2) {
      linkedSet.remove(i);
    }
  }
  
  @Override
  protected Node<T> find(T t) {
    for (Node<T> n = head; n != null; n = n.next) {
      if (n.data.equals(t)) {
        if (n == head) {
          return head;
        }
        // Remove target
        remove(n);
        // Prepend to linked list
        return prepend(t);
      }
    }
    return null;
  }
  
  private Node<T> prepend(T t) {
    if (head == null) {
      head = new Node<>(t);
      tail = head;
    }
    Node<T> newNode = new Node<>(t);
    head.prev = newNode;
    newNode.next = head;
    head = newNode;
    return newNode;
  }
  
}
