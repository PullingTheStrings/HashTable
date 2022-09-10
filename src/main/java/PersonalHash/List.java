package PersonalHash;

import java.util.Iterator;

public class List<T> implements Iterable<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public List() {
    size = 0;
  }

  private List(
      Node<T> head,
      Node<T> tail,
      int
          size) { // this constructor is private because it's only supposed to be used in the clone
                  // method
    this.head = head;
    this.tail = tail;
    this.size = size;
  }

  public void add(T thing) {
    Node<T> node = new Node(thing);
    addNode(node);
  }

  public void remove(T thing) {
    if (thing != null) {
      Node<T> node = new Node(thing);
      removeNode(node);
      size--;
    }
  }

  private void addNode(Node node) {
    if (head == null) { // if the list is empty
      head = node;
      tail = node; // both the head and tail will be that node
      size++; // increases the size
    } else {
      tail.setNext(node); // branch the node off the current tail
      tail = node; // make the node the new tail
      size++; // increase the size
    }
  }

  private void removeNode(Node node) {
    if (node.equals(head)) {
      head = head.getNext();
    } else if (head != null) {
      Node currentNode = head;
      while (currentNode.getNext() != null) {
        Node nextNode = currentNode.getNext();
        if(node.equals(nextNode)){
          currentNode.setNext(nextNode.getNext());
          if(nextNode==tail){
            tail=currentNode;
          }
        }

        currentNode=currentNode.getNext();
      }
    }
  }

  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  } // getters for head and tail

  public int size(){
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator<T>(this);
  }

  @Override
  public List<T> clone()
      throws CloneNotSupportedException { // makes the clone method for Lists public
    return new List<T>(head, tail, size);
  }
}
