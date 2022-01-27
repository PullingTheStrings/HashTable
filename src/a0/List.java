package a0;

public class List {

    private Node head;
    private Node tail;
    private int size;

    public List(){
        size=0;
    }
    public void add(int number){
        Node node=new Node(number);
        addNode(node);
    }

    private void addNode(Node node){
        if(head==null){
            head=node;
            tail=node;
            size++;
        }
        else{
            tail.setNext(node);
            tail=node;
            size++;
        }
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }


}
