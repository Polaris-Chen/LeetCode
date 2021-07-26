package LeetCode;

/**
 * @author polarisChen
 * @create 2021/7/9 12:10 下午
 */
public class _24 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head==null||head.next==null){
                return head;
            }
            ListNode temp=head.next;
            head.next=swapPairs(temp.next);
            temp.next=head;
            return temp;
        }
    }

}
