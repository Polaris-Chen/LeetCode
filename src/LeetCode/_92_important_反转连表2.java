package LeetCode;

/**
 * @author polarisChen
 * @create 2021/3/18 8:21 下午
 */
public class _92_important_反转连表2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode leftNode = prehead;
        ListNode rightNode = head;
        int l = 0;
        int r = 1;
        while (r != right) {
            if (l != left - 1) {
                leftNode = leftNode.next;
                l++;
            }
            rightNode = rightNode.next;
            r++;
        }

        rightNode = rightNode.next;
        ListNode x = reverse(leftNode.next, rightNode);
        leftNode.next.next = rightNode;
        leftNode.next = x;
        return prehead.next;
    }

    public ListNode reverse(ListNode head, ListNode rightNode) {
        ListNode p = head;
        ListNode q = null;
        while (p != null && !p.equals(rightNode)) {
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }
        return q;
    }
}
