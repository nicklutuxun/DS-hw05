package hw5;

/**
 * Set implemented using a doubly linked list and move-to-front heuristic.
 *
 * @param <T> Element type.
 */
public class MoveToFrontLinkedSet<T> extends LinkedSet<T> {

  // TODO: incorporate move-to-front heuristic each time a value is accessed.
  //  Override the relevant method(s) from LinkedSet.
  
  
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
