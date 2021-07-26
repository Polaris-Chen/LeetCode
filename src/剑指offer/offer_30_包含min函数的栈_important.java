package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author polarisChen
 * @create 2021/2/16 5:04 下午
 */
public class offer_30_包含min函数的栈_important {

//这个是我独立想出来的,还是很精妙的,就是栈中的每个元素都携带一个min值,代表从该元素到栈底的所有元素中的最小值,
    //而全局变量min代表了栈中的最小值
    //然后push的时候就要根据已有的min值对push进来的元素赋min值,并更新全局min值
    //pop的时候也要对应更新min值
    class MinStack {
        int min;
        ArrayList<int[]> stack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min = Integer.MAX_VALUE;
            stack = new ArrayList<>();
        }

        public void push(int x) {

            if (x < min) {
                min = x;
                stack.add(new int[]{x,x});
            }
            else {
                stack.add(new int[]{x,min});
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            if (stack.size()>0) {
                min = stack.get(stack.size() - 1)[1];
            }
            else {
                min=Integer.MAX_VALUE;
            }
        }

        public int top() {
            return stack.get(stack.size() - 1)[0];
        }

        public int min() {
            return min;
        }
    }


}
