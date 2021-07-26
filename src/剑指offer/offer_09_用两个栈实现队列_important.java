package 剑指offer;
import java.util.Stack;
/*
* 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

*
* */
//我的想法就是插入的元素就直接放在栈1,要删除的时候就把所有栈1中的元素转移到栈2中,然后弹出栈顶元素
//然后再把元素还给栈1,这样非常慢
//leetcode优化的算法是只要栈2不空,删除的时候就一个个弹出去,当栈2空但栈1不空的时候再把所有元素倒入栈2,这就省了很多时间
public class offer_09_用两个栈实现队列_important {


    static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1=new Stack<Integer>();
            stack2=new Stack<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);

        }
        //我的
        public int deleteHead() {


            stack2.clear();
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());

            }
            if (stack2.isEmpty()){
                return -1;
            }
            int result=stack2.pop();

            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return result;
        }
        //优化后的
        public int deleteHead1() {
            if (!stack2.isEmpty()){
                return stack2.pop();
            }
            else {
                if (stack1.isEmpty()){
                    return -1;
                }
                else {
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    return stack2.pop();
                }
            }
        }

    }

}
