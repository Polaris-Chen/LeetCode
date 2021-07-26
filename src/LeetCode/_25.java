package LeetCode;

/**
 * @author polarisChen
 * @create 2021/7/9 4:07 下午
 *
 *
 *
 * 重点就是要构建一个头发节点接在头结点前面,可以省去很多判断
 * 逻辑就是从头开始,先看看够不够k个,不够就直接结束,够的话就找好头和尾,放进反转方法里反转好,再把这段接回原链表里,最后还是直接返回hair.next
 */


public class _25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(-1,head);
        ListNode pre=hair;
        ListNode tail=null;
        while (head!=null){
            ListNode temp=pre;
            for (int i = 0; i <k ; i++) {
                temp=temp.next;
                if (temp==null){
                    return hair.next;
                }
            }
            tail=temp;
            ListNode tailNext=tail.next;
            ListNode[] t=reverse(head,tail);
            head=t[0];tail=t[1];
            pre.next=head;
            tail.next=tailNext;
            head=tailNext;
            pre=tail;
        }
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode p=head;
        ListNode q=null;
        while (p!=tail){
            ListNode temp=p.next;
            p.next=q;
            q=p;
            p=temp;
        }
        tail.next=q;
        return new ListNode[]{tail,head};
    }
}
