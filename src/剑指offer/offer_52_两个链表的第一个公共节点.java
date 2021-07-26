package 剑指offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author polarisChen
 * @create 2021/3/8 9:44 下午
 */

/*
* 一个优美的双指针,因为不确定谁长,那就每个指针都走一遍A和B两条链,最后相遇的时候肯定就是第一个重复的节点
* */
public class offer_52_两个链表的第一个公共节点 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          ListNode a=headA;
        ListNode b=headB;
        while (a!=b){
            if (a!=null){
                a=a.next;
            }
            else {
                a=headB;
            }

            if (b!=null){
                b=b.next;
            }
            else {
                b=headA;
            }
        }
        return null;
    }
}
