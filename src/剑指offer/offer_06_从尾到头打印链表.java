package 剑指offer;
//简单 就用栈换一下就行

import java.util.ArrayList;
import java.util.Stack;

public class offer_06_从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    ArrayList<Integer> arrayList=new ArrayList();
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack=new java.util.Stack<Integer>();

        while (head!=null){
            System.out.println(head.val);
            stack.push(head.val);
            head=head.next;
        }
        int[] result=new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            result[i]=stack.pop();
            i++;
        }
        return result;
    }
    //递归
    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[0];
        }
        reverse(head);
        int[] result=new int[arrayList.size()];
        for (int i = 0; i <arrayList.size() ; i++) {
            result[i]=arrayList.get(i);
        }
        return result;
    }
    public void reverse(ListNode a){
        if (a.next!=null) {
            reverse(a.next);
        }
        arrayList.add(a.val);
    }
}
