package hw5;

/**
 * Set implemented using plain Java arrays and transpose-sequential-search heuristic.
 *
 * @param <T> Element type.
 */
public class TransposeArraySet<T> extends ArraySet<T> {

  // TODO: incorporate the transpose-sequential-search heuristic
  //  each time a value is accessed. Override the relevant method(s) from ArraySet.
  
  
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
