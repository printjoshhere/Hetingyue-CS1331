class Main1{
   public static void main(String[] args){
      Integer[] myArray = new Integer[]{100,60,427,256,398,884,8,427,47678,8};
      LinkedList<Integer> myLinkedList = new LinkedList(myArray);
      Node<Integer> current = myLinkedList.getHead();
      System.out.println(current.getData());
      //add at the front of the list
      // System.out.println(myLinkedList.isEmpty());
      // System.out.println(myLinkedList.size());
      // System.out.println("Add elements into this list:");
      // myLinkedList.add(354);
      // System.out.println("this is my first list" + myLinkedList.toArray());
   //    //add to list at specific position: when index equals 2
      // myLinkedList.add(2, 444);
      // System.out.println("this is my second list" + myLinkedList.toArray());
   //    //============================================//
   //    //Using index to remove element
      // System.out.println("Remove elements from this list:"+ myLinkedList.toArray());
      // System.out.println("this is my first time remove element from this list");
      myLinkedList.remove(6);
      System.out.println(myLinkedList.toArray());
   //    //remove element.value == 398
      // System.out.println("this is my second time remove element from this list");
      // myLinkedList.removes(444);
      // System.out.println(myLinkedList.toArray());
   //    //remove head
      // System.out.println("this is my third time remove element, and remove first element from this list");
      // myLinkedList.remove();
      // System.out.println(myLinkedList.toArray());
      // System.out.println(myLinkedList.get(3));
      // System.out.println("this is my forth time remove element from this list");
      myLinkedList.removeDuplicates();
      Integer[] array = myLinkedList.toArray(); 
      for (int i=0; i<myLinkedList.size(); i++) {
         System.out.print(array[i]);
      }
      
      // myLinkedList.clear();
      // System.out.println(myLinkedList.isEmpty());
   }
}