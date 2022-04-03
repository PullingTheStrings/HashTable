package ElliotHash;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {
  private List<T> list;
  private Node<T> currentNode;


  public ListIterator(List<T> list) {
    if (list == null) {
      throw new IllegalArgumentException("List cannot be null");
    }
    this.list = list.clone();
    currentNode = this.list.getHead();

  }

  @Override
  public boolean hasNext() {
    return currentNode != null;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    T thing = currentNode.getValue();
    currentNode = currentNode.getNext();
    return thing;
  }
}
