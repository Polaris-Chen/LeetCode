package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/2/16 9:40 下午
 */
public class offer_35__复杂链表的复制_important {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //其实整体思路都是一样的 都是用一个容器方便找到random指针指向的节点,只不过他用了哈希表,我用的是数组
    //他的思路就是先创建所有新节点和构建老节点和新节点的联系,然后就可以通过老节点找到新节点
    //然后对于每个老节点,找到他的next和random节点,并找到对应的新节点,然后再把新节点之间的指针指上去
    class Solution {
        public Node copyRandomList1(Node head) {
            Node p = head;
            HashMap<Node, Node> hashMap = new HashMap<>();
            while (p != null) {
                hashMap.put(p, new Node(p.val));
                p = p.next;
            }
            Node newhead = hashMap.get(head);
            while (head != null) {
                Node oldnext = head.next;
                Node newnext = hashMap.get(oldnext);
                Node oldrandom = head.random;
                Node newrandom = hashMap.get(oldrandom);
                hashMap.get(head).random = newrandom;
                hashMap.get(head).next = newnext;
                head = head.next;
            }
            return newhead;
        }

        //我是使用了一个数组,每次要搜索random指针就去找一遍,肯定很费时间嘛
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            ArrayList<Node> oldArr = new ArrayList<>();
            while (head != null) {
                oldArr.add(head);
                head = head.next;
            }
            ArrayList<Node> newArr = new ArrayList<>();
            Node newhead = new Node(0);
            Node p = newhead;
            for (int i = 0; i < oldArr.size(); i++) {
                newArr.add(new Node(0));
            }
            for (int i = 0; i < oldArr.size(); i++) {
                Node oldNode = oldArr.get(i);
                Node newNode = newArr.get(i);
                newNode.val = oldNode.val;
                p.next = newNode;
                p = p.next;
                if (oldNode.random != null) {
                    newNode.random = newArr.get(oldArr.indexOf(oldNode.random));
                } else {
                    newNode.random = null;
                }
            }
            return newhead.next;
        }
    }
}
