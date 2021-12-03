public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.next = next;
        this.data = data;
    }

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public E getData() {
        return this.data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return this.next;
    }
}