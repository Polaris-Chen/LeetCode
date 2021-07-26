package 剑指offer;

import java.util.Stack;

/**
 * @author polarisChen
 * @create 2021/2/16 5:41 下午
 */
public class offer_31_栈的压入弹出序列_important {
    //我自己的想法还是很难懂的  用一个栈来模拟其实是更好的办法
    //就是从第一个入栈元素开始,先入栈,然后比较栈顶元素和出栈序列的指针元素是否相同,相同就出栈,然后一直出栈直到栈顶元素和出栈序列指针元素不同
    //到最后如果栈空就证明是一个合法的序列
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k = 0; k < pushed.length; k++) {
            stack.push(pushed[k]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    //我自己的想法就是顺序查看出栈数组中的所有元素,对于每一个元素,都考察是否满足错误的条件
    //错误的条件只有一个,就是对于某个元素出栈之后,后面的出栈序列必须按降序排列
    //例如 我现在5出栈了 后面可以没有1234,也可以4321,421,41,但是绝对不能241.
    //因此我设定了一块禁止区间,例如入栈顺序是12345,当前的出栈元素是5,总的出栈顺序是43521,我就从5开始看到最后,也就是看521
    //碰到的第一个比5小的元素作为左边界,5作为右边界,这里就是2和5组成了一段禁止区域(在入栈顺序中)
    //此后我在出栈顺序中碰到的任意一个节点我都去考察是否落在这个区域中,如果是,那就是非法序列,如果全都看完了都没事那就是合法序列
    //例如 入栈是12345  出栈是15243  我这个时候在出栈序列从5往后看,找到第一个在入栈序列中位于他左边的数,是2,那我就在入栈序列中
    //找到了一段禁止区域,就是2-5,也就是说,5出栈,2也出栈后,2和5之间的元素都不可能出栈了,因此后面的4就落入了禁止区域,就是非法了
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length == 0) {
            return true;
        }
        if (pushed.length == 0) {
            return false;
        }
        int max = popped[0];
        for (int i = 0; i < popped.length; i++) {
            if (popped[i] < max) {
                continue;
            } else {
                max = popped[i];
            }
            int now = popped[i];
            int right = search(now, pushed);
            int left = right;
            int flag = 0;
            for (int j = i + 1; j < popped.length; j++) {
                int location = search(popped[j], pushed);
                if (flag == 0 && location < right) {
                    left = location;
                    flag = 1;
                    continue;
                }

                if (location > left && location < right) {
                    return false;
                }

            }

        }
        return true;
    }

    public int search(int x, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
