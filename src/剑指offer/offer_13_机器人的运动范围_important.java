package 剑指offer;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
// 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



//深搜简单  我之前老想dp,但其实这题没法dp,浪费时间,不如直接遍历
public class offer_13_机器人的运动范围_important {
    static class Solution {
        //直接从0,0开始调用递归算法
        public int movingCount(int m, int n, int k) {
            int sum=0;
            boolean[][] used=new boolean[m][n];
            sum+=aux_movingCount(m,n,0,0,k,used);
            return sum;
        }
        //递归辅助算法
        public int aux_movingCount(int m, int n,int nowM,int nowN, int k,boolean[][] used) {
            //如果超出边界或者和大于k或者已经访问过,就返回0,证明这条路不通了
            if (nowM>m-1||nowM<0||nowN>n-1||nowN<0||sum(nowM,nowN)>k||used[nowM][nowN]){
                return 0;
            }
            //访问数组置为true
            used[nowM][nowN]=true;
            //当前点也是符合的,要加上
            int sum=1;

            //因为只能往下和往右所以没必要往左上遍历了
            sum+=aux_movingCount(m,n,nowM+1,nowN,k,used)
                    //+aux_movingCount(m,n,nowM-1,nowN,k,used)
                    +aux_movingCount(m,n,nowM,nowN+1,k,used);
                    //+aux_movingCount(m,n,nowM,nowN-1,k,used);
            return sum;

        }
        //按位求和函数
        public int sum(int m,int n){
            int sumM=0,sumN=0;
            while (m>0){
                sumM+=m-m/10*10;
                m/=10;
            }
            while (n>0){
                sumN+=n-n/10*10;
                n/=10;
            }
            return sumM+sumN;
        }
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.movingCount(38,15,9));
    }
}
