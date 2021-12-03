import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
    private Node<E> next;

    public LinkedListIterator(LinkedList<E> myList) {
        this.next = myList.getHead();
    }

    public boolean hasNext() {
        // yao's code
        if(this.next == null){
            return false;
        }
        if(this.next != null && this.next.getNext() == null){
            return true;
        } else if(this.next.getNext() == null){
            return false;
        }
        return true;

        // He Tingyue's code
        // int counter = 0;
        // if (this.next != null && next.getNext() == null) {
        //     return true;
        // }
        // if (this.next != null) {
        //     counter = 1;
        //     while (this.next.getNext() != null) {
        //         counter++;
        //     }
        //     if (counter > 1) {
        //         return true;
        //     } else if (counter == 1) {
        //         return false;
        //     }
        // }
        // return false;
    }

    public E next() {
        // yao's code
        if(!this.hasNext()){
            throw new NoSuchElementException("No such element exists in this list");
        }

        return this.next.getNext().getData();

        // Hetingyue's code
    //        E nodeData = this.next.getData();
    // //     if (this.next != null){
    // //         if (this.next.getNext() == null) {
    // //         return nodeData;
    // //     }
    // //     if (this.next == null && this.next.getNext() == null) {
    // //         throw new NoSuchElementException("No such element exists in this list");
    // //     } else if (this.next.getNext() == null) {
    // //         throw new NoSuchElementException("No such element exists in this list");
    // //     } else if (this.next.getNext() != null) {
    // //         next = next.getNext();
    // //         nodeData = this.next.getData();
    // //         return nodeData;
    // // }
    // //     return nodeData;
    // if (hasNext()==false) {
    //     throw new NoSuchElementException("No such element exists in this list");
    // } else {
    //         if (this.next != null && this.next.getNext() == null) {
    //         return nodeData;
    //     } else if (this.next != null && this.next.getNext() != null) {
    //         next = next.getNext();
    //         nodeData = this.next.getData();
    //     }
    //     return nodeData;
    // }
    }
    
}