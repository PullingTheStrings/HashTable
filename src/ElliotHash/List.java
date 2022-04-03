package ElliotHash;

import java.util.Iterator;

public class List<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public List(){
        size=0;
    }
    public void add(T thing){
        Node<T> node=new Node(thing);
        addNode(node);
    }

    public void addNode(Node node){
        if(head==null){//if the list is empty
            head=node;
            tail=node;//both the head and tail will be that node
            size++;//increases the size
        }
        else{
            tail.setNext(node);//branch the node off the current tail
            tail=node;//make the node the new tail
            size++;//increase the size
        }
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }//getters for head and tail

    @Override
    public Iterator<T> iterator(){
        return new ListIterator<T>(this);
    }

    @Override
    public List<T> clone(){//makes the clone method for Lists public
        return clone();
    }


}
