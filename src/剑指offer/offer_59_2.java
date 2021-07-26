package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author polarisChen
 * @create 2021/4/26 3:20 下午
 *
 * 整体的思想就是 用一个双向队列存储最小值的列表
 * 每次push的时候更新这个辅助队列 把比加入的值小的所有值都删了,因为这些值都没用了,我后面进来,还比你们都大,那在我出去之前你们肯定都出去了
 * 但我的值比你们大,所以最大值肯定不是你们,全删完之后把自己加到右边
 * 取最大值就直接返回这个双端队列的最左边的值
 * 每次pop的时候,就判断一下弹出的是不是这个双端队列最左边的值,如果是,那就把辅助队列里的这个值也弹出去
 */
public class offer_59_2 {
    class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> aux_queue;
        public MaxQueue() {
            this.queue=new LinkedList<>();
            this.aux_queue=new LinkedList<>();
        }

        public int max_value() {
            return aux_queue.isEmpty()?-1:aux_queue.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while((!aux_queue.isEmpty())&&aux_queue.peekLast()<value){
                aux_queue.pollLast();
            }
            aux_queue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()){
                return -1;
            }
            if (queue.peek().equals(aux_queue.peekFirst())){
                aux_queue.pollFirst();
            }
            return queue.poll();

        }
    }
}
