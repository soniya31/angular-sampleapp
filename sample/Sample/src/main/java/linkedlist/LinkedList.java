package linkedlist;

public class LinkedList {


    static Node a, b;
    Node head;  // head of list

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
        list.a = new Node(5);
        list.a.next = new Node(10);
        list.a.next.next = new Node(15);

        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(20);

        System.out.println("List a before merge :");
        list.printlist(a);
        System.out.println("");
        System.out.println("List b before merge :");
        list.printlist(b);

        // merge two sorted linkedlist in decreasing order
        result = list.mergeLists(a, b);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);

    }

    void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    Node sortedmerge(Node node1, Node node2) {

        // if both the nodes are null
        if (node1 == null && node2 == null) {
            return null;
        }

        // resultant node
        Node res = null;

        // if both of them have nodes present traverse them
        while (node1 != null && node2 != null) {

            // Now compare both nodes current data
            if (node1.data <= node2.data) {
                Node temp = node1.next;
                node1.next = res;
                res = node1;
                node1 = temp;
            } else {
                Node temp = node2.next;
                node2.next = res;
                res = node2;
                node2 = temp;
            }
        }

        // If second list reached end, but first list has
        // nodes. Add remaining nodes of first list at the
        // front of result list
        while (node1 != null) {
            Node temp = node1.next;
            node1.next = res;
            res = node1;
            node1 = temp;
        }

        // If first list reached end, but second list has
        // node. Add remaining nodes of first list at the
        // front of result list
        while (node2 != null) {
            Node temp = node2.next;
            node2.next = res;
            res = node2;
            node2 = temp;
        }

        return res;

    }

    Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node mergestart = null;
        Node mergeend=null;
        while (headA != null && headB != null) {

            if (headA.data < headB.data) {

                if (mergestart == null) {
                    Node copy = headA;
                      copy.next = null;
                    mergestart = copy;
                    mergeend=mergestart;

                } else {
                    Node copy = headA;
                    //copy.next = null;
                    mergeend.next = copy;
                    mergeend=copy;

                }
                headA = headA.next;
            } else {
                if (mergestart == null) {
                    Node copy = headB;
                    copy.next = null;
                    mergestart = copy;
                    mergeend=mergestart;

                } else {
                    Node copy = headB;
                    //copy.next = null;
                    mergeend.next = copy;
                    mergeend=copy;

                }
                headB = headB.next;
            }
        }
       /* if (headA != null) {
            if (merge == null)
                merge = headA;
            else
                merge.next = headA;
        }
        if (headB != null) {
            if (merge == null)
                merge = headB;
            else
                merge.next = headB;
        }*/
        return mergeend;

    }

    /* Node Class */
    static class Node {

        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

}
