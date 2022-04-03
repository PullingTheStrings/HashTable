package ElliotHash;

public class Node<T> {




    private T value;
    private Node next;


    public Node(T value){
        this.value=value;

    }
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value=value;
    }

    public Node getNext() {
        try{return next;}
        catch(Exception e){
            return null;
        }
    }

    public void setNext(Node next) {
        this.next = next;
    }
}