import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author polarisChen
 * @create 2021/3/16 4:09 下午
 */
class LFUCache {
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int capacity;
    public LFUCache(int capacity) {
        head=new ListNode(-2,-2);
        tail=new ListNode(-1,-1);
        map=new HashMap<>();
        this.capacity=capacity;
        head.next=tail;
        tail.pre=head;

    }

    public int get(int key) {
        if (!map.containsKey(key)){

            return -1;
        }
        ListNode temp=map.get(key);
        temp.num++;
        ListNode tempNext=temp.next;
        delete(temp);
        move(temp,tempNext);
        return temp.value;
    }
        void delete(ListNode x){
            x.pre.next=x.next;
            x.next.pre=x.pre;
        }
        void move(ListNode x,ListNode start){
            while (start.value!=-1&&start.num<=x.num){
                start=start.next;
            }
            x.next=start;
            x.pre=start.pre;
            start.pre.next=x;
            start.pre=x;
        }
    public void put(int key, int value) {
        if (capacity==0){
            return;
        }
        if (get(key)!=-1){
            map.get(key).value=value;
        }
        else {

            ListNode newNode=new ListNode(key,value);
            map.put(key,newNode);
            if (map.size()>capacity){
                map.remove(head.next.key);
                delete(head.next);
            }
            newNode.num++;
            move(newNode,head);

        }
    }
    class ListNode{
        int key;
        int value;
        int num;
        ListNode next;
        ListNode pre;
        public ListNode(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.pre=null;
            num=0;
        }
    }
}