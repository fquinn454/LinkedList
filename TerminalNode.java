public class TerminalNode implements LinkedList {
    int element;
    LinkedList next = null;

    public TerminalNode(int element){
        this.element = element;
    }
    @Override
    public LinkedList getNext() {
        return null;
    }

    @Override
    public int getElement() {
        return this.element;
    }
}
