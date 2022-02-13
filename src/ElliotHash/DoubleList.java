package ElliotHash;

public class DoubleList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public DoubleList(){
        size=0;
    }
    public void add(List list){
        ListNode<T> node=new ListNode(list);
        addNode(node);
    }

    private void addNode(ListNode<T> node){
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
    public ListNode getHead(){
        return head;
    }
    public ListNode getTail(){
        return tail;
    }
}
