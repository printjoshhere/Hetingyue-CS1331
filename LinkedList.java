import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {
   private int size;
   private Node<T> head;

   public LinkedList() {
      this.head = null;
      this.size = 0;
   }

   public LinkedList(T[] arr) {
      this.head = null;
      this.size = arr.length;
      for (int i = this.size-1; i >= 0; i--) {
         Node<T> cur = new Node<T> (arr[i], this.head);
         this.head = cur;
      }
   }

   public void add(T element) {
      Node<T> cur = new Node<T>(element);
      if (element == null) {
         throw new IllegalArgumentException("Please input valid element!");
      } else {
         cur.setNext(this.head);
         this.head = cur;
      }
      this.size = this.size + 1;
   }
   
   public void add(int index, T element) {
      if (element == null) {
         throw new IllegalArgumentException("Please input valid element!");
      }
      if (index > this.size || index < 0) {
         throw new IndexOutOfBoundsException ("The index is out of bounds!");
      } 
      if (index == 0) {
         add(element);
         return;
      }
      Node<T> front = this.head;
      int counter = 0;
      while(counter < index - 1) {
         front = front.getNext();
         counter++;
      }
      Node<T> add = new Node<T>(element);
      add.setNext(front.getNext());
      front.setNext(add);
      this.size = this.size + 1;
   }

   public T remove(int index) {
      if (index >= this.size || index < 0) { 
         throw new IndexOutOfBoundsException("The index is out of bounds!");
      }
      if (index == 0) {
         T value = this.head.getData();
         this.head=this.head.getNext();
         this.size--;
         return value;
      }
      Node<T> prev = this.head;
      for (int i = 0; i<index-1 ;i++){
         prev = prev.getNext();
      }
      T value = prev.getNext().getData();
      prev.setNext(prev.getNext().getNext());
      this.size--;
      return value;
   }

   public T removes(T element) {
      if (element == null){
         throw new IllegalArgumentException(" Element is not valid");
      }
      Node<T> cur = this.head;
      boolean existence = true;
      for (int i = 0; i<this.size;i++){
         if(cur.getData() == element){
            remove(i);
            existence = false;
            i--;
         }
         cur=cur.getNext();
      }
      if (existence){
         throw new NoSuchElementException("Element is not in the list");
      }
      return element;
   }

   public T remove() {
      if (this.size == 0){
         return null;
      }
      T value = this.head.getData();
      this.head = this.head.getNext();
      return value;
   }

   public T get(int index) {
      if (index >= this.size || index < 0) {
         throw new IndexOutOfBoundsException("The index is out of bounds!");
      } 
      Node<T> cur = this.head;
      for (int i = 0; i<index;i++){
         cur = cur.getNext();
      }
      return cur.getData();
   }

   public boolean contains(T element) {
      if (element == null) {
         throw new IllegalArgumentException("Please input valid element!");
      }
      Node<T> cur = this.head;
      for (int i = 0; i<this.size;i++){
         if (cur.getData() == element){
            return true;
         }
         cur=cur.getNext();
      }
      return false;
   }

   public T set(int index, T element) {
      if (element == null) {
         throw new IllegalArgumentException("Please input valid element!");
      }
      if (index >= this.size || index < 0) {
         throw new IndexOutOfBoundsException("The index is out of bounds");
      }
      Node<T> cur = this.head;
      for (int i = 0; i<index;i++){
         cur = cur.getNext();
      }
      cur.setData(element);
      return element;
   }

   public void clear() {
      this.head = null;
      this.size = 0;
   }

   public boolean isEmpty() {
      if (this.size == 0) {
         return true;
      }
      return false;
   }

   public int size() {
      return this.size;
   }

   public Node<T> getHead(){
      return this.head;
   }

   public void removeDuplicates() {
      if (this.size <= 1){
         return;
      }
      Node<T> cur = this.head;
      for (int i = 0; i<this.size;i++){
         T target = cur.getData();
         Node<T> check = cur.getNext();
         for (int j = i+1; j<this.size;j++){
            if(check.getData().equals(target)){
               remove(j);
               j--;
            }
            else {
               check = check.getNext();
            }
         }
         cur=cur.getNext();
      }
   }

   public T[] toArray() {
      T[] arr = (T[]) new Object[this.size];
      Node<T> cur = head;
      for (int i = 0; i < this.size; i++) {
         arr[i] = cur.getData();
         cur = cur.getNext();
      }
      return arr;
   }

   @Override
   public Iterator<T> iterator(){
      LinkedListIterator<T> LLIterator = new LinkedListIterator<T>(this);
      return LLIterator;
   }
}