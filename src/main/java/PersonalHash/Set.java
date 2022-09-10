package PersonalHash;

import java.util.Iterator;

public class Set<T> implements Iterable<T> {

  private List<T> list;
  private LimitedHashTable<T> table;
  private int size;

  public Set() {
    list = new List<>();
    table = new LimitedHashTableImpl<>(100000);
    size = 0;
  }

  public void put(T thing) {

    if (!contains(thing)) {
      table.put(thing);
      list.add(thing);
      size++;
    }
  }

  public void remove(T thing) {
    if (contains(thing)) {
      list.remove(thing);
      table.remove(thing);
      size--;
    }
  }

  public boolean contains(T thing) {
    return table.contains(thing);
  }

  public Iterator<T> iterator() {
    Iterator<T> iterator = new ListIterator(list);
    return iterator;
  }
  public int size(){
    return size;
  }
}
