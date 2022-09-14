package PersonalHash;

public class Node<T> {

    private T value;
    private Node next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        try {
            return next;
        } catch (Exception e) {
            return null;
        }
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object node) {
        if (!(node instanceof Node) || node == null) {
            return false;
        } else {
            boolean equalValue;
            try {
                equalValue = value.equals(((Node) node).getValue());
            } catch (NullPointerException e) {
                equalValue = ((Node) node).getValue() == null;
            }
            boolean equalNext;
            try {
                equalNext = next.equals(((Node) node).getNext());
            } catch (NullPointerException e) {
                equalNext = ((Node) node).getNext() == null;
            }
            return equalNext && equalValue;
        }
    }
}
