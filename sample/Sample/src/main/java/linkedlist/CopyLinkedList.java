package linkedlist;

import java.util.Stack;

public class CopyLinkedList {
    static CopyLinkedList.Node a, b;
    CopyLinkedList.Node head;  // head of list

    public static void main(String[] args) {

        CopyLinkedList list = new CopyLinkedList();
        CopyLinkedList.Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
        list.a = new CopyLinkedList.Node(5);
        list.a.next = new CopyLinkedList.Node(10);
        list.a.next.next = new CopyLinkedList.Node(15);

        list.b = new CopyLinkedList.Node(2);
        list.b.next = new CopyLinkedList.Node(3);
        list.b.next.next = new CopyLinkedList.Node(20);

        System.out.println("List a before merge :");
        //list.printlist(a);
        //System.out.println("");
        //System.out.println("List b before merge :");
        //list.printlist(b);
        System.out.println(GetNode(a,0));
        // merge two sorted CopyLinkedList in decreasing order
        result = list.copyLists(a);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);

    }

    void printlist(CopyLinkedList.Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    Node copyLists(Node a) {

        Node be=null;
        Node bs=null;
        while(a!=null){
           Node next=a.next;
           a.next=null;
           if(be==null)
           {
               bs=a;
               be=bs;

           }
           else{
               be.next=a;
               be=a;
           }
           a=next;
        }
return bs;
    }

    static class Node {

        int data;
        CopyLinkedList.Node next;

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    static int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Stack<Integer> stack=new Stack<Integer>();
        while(head!=null) {
            stack.push(head.data);
head=head.next;
        }

        for(int i=0;i<n;i++){
            int a=stack.pop();
        }
        return stack.pop();


    }
}
