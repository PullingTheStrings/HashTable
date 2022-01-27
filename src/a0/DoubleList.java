package a0;

public class DoubleList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public DoubleList(){
        size=0;
    }
    public void add(List list){
        ListNode node=new ListNode(list);
        addNode(node);
    }

    private void addNode(ListNode node){
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
