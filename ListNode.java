public class ListNode implements LinkedList {
    int element;
    LinkedList next;

    public ListNode(int element, LinkedList next){
        this.element = element;
        this.next = next;
    }
    @Override
    public LinkedList getNext() {
        return this.next;
    }

    @Override
    public int getElement() {
        return this.element;
    }
}
