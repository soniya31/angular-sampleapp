package linkedlist;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ReverseLinkedList {

    static Node head;

    static void reverseUtil(Node node) {
        Node next = null;
        Node prev = null;
        Node cur = node;
        while (cur != null) {

            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        node = prev;
        printNodes(node);
    }

    static void printNodes(Node node) {
        while (node != null) {
            System.out.println("Node:" + node.data);
            node = node.next;
        }
    }

    static void findMidElement(Node head) {
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != null && fast.next!=null) {

            fast = fast.next.next;
            slow = slow.next;

        }
        System.out.println(slow.data);

    }

    public static void main(String[] args) {

        ReverseLinkedList.head = new Node(1);
        ReverseLinkedList.head.next = new Node(2);
        ReverseLinkedList.head.next.next = new Node(3);
        ReverseLinkedList.head.next.next.next = new Node(4);
        ReverseLinkedList.head.next.next.next.next = new Node(5);
        ReverseLinkedList.head.next.next.next.next.next = new Node(6);
        ReverseLinkedList.head.next.next.next.next.next.next = new Node(7);

     //   printNodes(head);
        delete(head,3);
       // System.out.println("Find Mid point");
        //findMidElement(head);


        //System.out.println("*************************************");
       // System.out.println("After reversal");
        //reverseUtil(head);
    }

    public static void delete(Node head, int k)
    {
        // Your code here

        Node current=head;
        Node prev=null;
        while(current!=null && current.next !=null)
        {
            int counter=1;
            while(counter<k)
            {
                prev=current;
                current=current.next;
                counter++;
            }

            prev.next=current.next;
            current=current.next;
        }
       printNodes(head);
    }
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }
}
