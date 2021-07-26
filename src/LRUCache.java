import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author polarisChen
 * @create 2021/3/16 1:29 下午
 */
/*
* 本质就是一个双端列表加一个hashMap,
* 每次get的时候都把获得的元素放到头上
* 每次put的时候就看情况,如果已经在里面了,这个时候get方法就已经把节点放到头上去了,直接修改head的next节点就行
* 如果不在里面,就需要再新建一个节点然后放到头上,并判断容量,如果大于capacity了,那就把尾巴的删了,注意,同时要删掉map里的值
* */
class LRUCache {


    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;
    int capacity;
    public LRUCache(int capacity) {

        this.capacity=capacity;
        map=new HashMap<>();
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }
        ListNode temp=map.get(key);
        delete(temp);
        move(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        //如果存在了,那get已经将节点放到头上了
        if(get(key)!=-1){
            head.next.value=value;
        }
        //如果不存在,就新建节点放到头上
        else{
            ListNode newNode=new ListNode(key,value);
            move(newNode);
            map.put(key,newNode);
            if(map.size()>capacity){
                map.remove(tail.pre.key);
                delete(tail.pre);
            }
        }

    }
    //把一个单独的节点放到头结点后面
    void move(ListNode x){
        x.next=head.next;
        head.next.pre=x;
        x.pre=head;
        head.next=x;
    }
    //删除某一个节点
    void delete(ListNode x){
        x.pre.next=x.next;
        x.next.pre=x.pre;
    }
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode pre;
        public ListNode(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.pre=null;
        }
    }
}
