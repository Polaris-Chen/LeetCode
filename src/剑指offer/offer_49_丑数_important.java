package 剑指offer;

import java.util.*;

/**
 * @author polarisChen
 * @create 2021/3/3 9:53 下午
 */
public class offer_49_丑数_important {
    //自己的错误解法,把每一个丑数都x2,x3,x5获得全部的丑数,但是x2肯定跟不上x5的速度,所以会让数组顺序乱掉而且非常的长,
// 比如要第100个,可能数组已经200了还没算到第100个
    public int nthUglyNumber(int n) {
        Queue<Integer> q = new LinkedList();
        Set<Integer> result = new HashSet<>();
        q.add(1);
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            if (!result.contains(temp)) {
                result.add(temp);
                if (result.size() > n) {
                    break;
                }
            } else {
                continue;
            }
            q.add(temp * 2);
            q.add(temp * 3);
            q.add(temp * 5);
        }
        ArrayList<Integer> a = new ArrayList<>(result);
        a.sort(Comparator.naturalOrder());
        System.out.println(a.toString());
        return a.get(n - 1);
    }

    //大佬的解法,就是通过指针限制每个丑数需不需要乘2,3,5  设置3个指针a,b,c 都是从0开始一位位移动的,
    // 比如a移动到第4位那证明前面三个丑数都乘过2了.
    //然后第n位的丑数肯定是(a位丑数x2,b位丑数x3,c位丑数x5)中的最小值,因为指针是按顺序一个个来的嘛,指针之前的元素都已经用过了
    //然后为什么是最小值呢,因为大一点的值也是丑数,肯定排在后面,现在还用不到,
    //这种方法其实就是限制了x5的速度,让2和5比较同步,2指针会走的快,5指针走的慢
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];  // 使用dp数组来存储丑数序列
            dp[0] = 1;  // dp[0]已知为1
            int a = 0, b = 0, c = 0;    // 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c

            for (int i = 1; i < n; i++) {
                // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘2来得到下个丑数，同理第c个数
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) {
                    a++; // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
                }
                if (dp[i] == n3) {
                    b++; // 第 b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数
                }
                if (dp[i] == n5) {
                    c++; // 第 c个数已经通过乘5得到了一个新的丑数，那下个需要通过乘5得到一个新的丑数的数应该是第(c+1)个数
                }
            }
            return dp[n - 1];
        }
    }
}
