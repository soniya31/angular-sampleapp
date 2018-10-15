package pratices;

public class ReverseLinkedList {

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
 Node head = new Node(12);
 head.next = new Node(43);
 head.next.next = new Node(56);
 head.next.next.next = new Node(34);
 head.next.next.next.next =new Node(45);
 printList(head);
        reverseList(head);




  }
  static void reverseList(Node head){

        Node curr = head;
        Node pev = null;
        Node nex = null;
        while(curr.next != null ){
           nex = curr.next;
           curr.next = pev;
           pev = curr;
           curr = nex;
      }
      curr.next =pev;
      printList(curr);
  }

  static void printList(Node head){

      while(head != null){

          System.out.println(head.val);
          head = head.next;

      }


  }
}
