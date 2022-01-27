package a0;

public class Node<T> {
    private int key;



    private T value;
    private Node next;

    public Node(T value, int key){
        this.value=value;
        this.key=key;
    }
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value=value;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node node){
        next=node;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
