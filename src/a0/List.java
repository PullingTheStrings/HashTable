package a0;

public class List<T> {

    private Node head;
    private Node tail;
    private int size;

    public List(){
        size=0;
    }
    public void add(T value,int key){
        Node<T> node=new Node(value,key);
        addNode(node);
    }

    private void addNode(Node node){
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


}
