package ElliotHash;

public class ListNode<T> {
    private List<T> value;
    private ListNode next;

    public ListNode(List<T> value){
        this.value=value;
    }
    public List getValue(){
        return value;
    }
    public void setValue(List<T> value){
        this.value=value;
    }
    public ListNode getNext(){
        return next;
    }
    public void setNext(ListNode node){
        next=node;
    }
}
