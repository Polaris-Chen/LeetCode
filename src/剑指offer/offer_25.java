package 剑指offer;

/**
 * @author polarisChen
 * @create 2021/2/14 10:17 下午
 * 就是简单的几个指针,一个指左边一个右边,谁小就把结果链表指向小的然后向后跳一个
 */
public class offer_25 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a=l1;
        ListNode b=l2;
        ListNode r=new ListNode(0);
        ListNode head=r;
        while (a!=null&&b!=null){
            if (a.val>b.val){
                r.next=b;
                r=r.next;
                b=b.next;
            }
            else {
                r.next=a;
                r=r.next;
                a=a.next;
            }
        }

        if (a==null){
            r.next=b;
        }
        else {
            r.next=a;
        }
        return head.next;
    }
}
