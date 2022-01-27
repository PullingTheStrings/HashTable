package a0;

public class ListNode {
    private List value;
    private ListNode next;

    public ListNode(List value){
        this.value=value;
    }
    public List getValue(){
        return value;
    }
    public void setValue(List value){
        this.value=value;
    }
    public ListNode getNext(){
        return next;
    }
    public void setNext(ListNode node){
        next=node;
    }
}
