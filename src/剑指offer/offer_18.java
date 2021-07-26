package 剑指offer;

public class offer_18 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            head=head.next;
        }
        ListNode p=head.next;
        ListNode q=head;
        while(p!=null){

            if (p.val==val){
                q.next=p.next;
            }

            p=p.next;
            q=q.next;
        }
        return head;
    }
}
