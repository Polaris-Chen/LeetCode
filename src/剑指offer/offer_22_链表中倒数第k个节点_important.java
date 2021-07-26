package 剑指offer;

import java.util.Stack;

/**
 * @author polarisChen
 * @create 2021/2/14 9:46 下午
 */
public class offer_22_链表中倒数第k个节点_important {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //第一想法是栈 不过双指针更快一点
 //就是前一个指针指向要返回的节点,后一个指针去遍历,一直保持k-1的距离,等后一个指针走到底就找到了倒数第k个
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head==null){
            return null;
        }
        ListNode q=head;
        ListNode p=head;
        int x=k-1;
        while (x>0){
          p=p.next;
          x--;
        }
        while (p.next!=null){
            p=p.next;
            q=q.next;
        }
        return q;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }
        Stack<ListNode> s=new Stack<>();
        while (head!=null){
            s.add(head);
            head=head.next;
        }
        ListNode x=new ListNode(0);
        while (k!=0){
            k--;
            x=s.pop();
            if (k==0){
                return x;
            }
        }
        return x;
    }
}
