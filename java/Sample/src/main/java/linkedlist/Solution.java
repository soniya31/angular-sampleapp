package linkedlist;

public class Solution {

    public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        if(n1 == null && n2 == null)
            return null;

        if(n1 == null)
            return n2;
        if(n2 == null)
            return n1;


        int carry =0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        if(n1 != null || n2 !=null){
            while(n1 !=null || n2 !=null){
                int a = n1!= null?n1.val:0 ;
                int b =n2 != null?n2.val:0 ;
                int total = a+ b + carry;
                ListNode n = new ListNode(total%10);
                result.next = n;
                result =n ;
                carry= total >=10?1:0;
                n1 =n1!=null?n1.next : null;
                n2=n2!=null?n2.next : null;
            }

        }

        if(carry != 0){
            ListNode n = new ListNode(carry);
            result.next =n;
            result.next.next =null;
        }

        return head.next;
    }

}

 class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
