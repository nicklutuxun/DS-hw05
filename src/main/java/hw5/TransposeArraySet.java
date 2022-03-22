package hw5;

/**
 * Set implemented using plain Java arrays and transpose-sequential-search heuristic.
 *
 * @param <T> Element type.
 */
public class TransposeArraySet<T> extends ArraySet<T> {
  
  /**
   * Main function used in hacking linear search.
   * @param args NA
   */
  public static void main(String[] args) {
    TransposeArraySet<Integer> arraySet = new TransposeArraySet<>();
    for (int i = 0; i < 10; i++) {
      arraySet.insert(i);
    }
    for (int i = 0; i < 10; i = i + 2) {
      arraySet.has(i);
    }
    for (int i = 0; i < 10; i = i + 2) {
      arraySet.remove(Integer.valueOf(i));
    }
  }
  
  @Override
  protected int find(T t) {
    for (int i = 0; i < numElements; i++) {
      if (t.equals(data[i])) {
        if (i == 0) {
          return i;
        }
        return swapWithPredecessor(i);
      }
    }
    return -1;
  }
  
  private int swapWithPredecessor(int i) {
    T temp = data[i];
    data[i] = data[i - 1];
    data[i - 1] = temp;
    return i - 1;
  }
}
