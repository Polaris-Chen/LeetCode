package 剑指offer;

import java.util.List;
import java.util.Stack;

public class offer_24_反转链表_important {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//自己的垃圾算法
    public ListNode reverseList(ListNode head) {
      if (head==null){
        return null;
      }
        Stack<ListNode> s=new Stack();
        ListNode t=head;
        while (t!=null){
          s.add(t);
          ListNode a=t;
          t=t.next;
          a.next=null;
        }
        ListNode x=s.pop();
        ListNode y=x;
        while (!s.isEmpty()){

          y.next=s.pop();
          y=y.next;
          System.out.println(y.val);
        }
        return x;
    }
//迭代
  class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode mid = head, pre = null;
      while(mid != null) {
        ListNode nextNode = mid.next; // 存一下后一个节点
        mid.next = pre;          // 把中间节点的next指向前一个节点
        pre = mid;               // pre往前走一个
        mid = nextNode;          // mid往前走一个
      }
      return pre;
    }
  }
  //递归
    public ListNode reverseList2(ListNode head) {
      return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
      if (cur == null) return pre; // 终止条件
      ListNode res = recur(cur.next, cur);  // 递归后继节点
      cur.next = pre;              // 修改节点引用指向
      return res;                  // 返回反转链表的头节点
    }



}
