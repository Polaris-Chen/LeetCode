package LeetCode;
//速度好像并没有改变,但是代码量简单了很多
//思路就是temp代表了向左走和向右走的最大收益
//而向左走的最大收益=左节点向右走的最大收益+1,向右走同理
//这就是动态规划的思路了
public class _1372_opt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max=0;
    public int longestZigZag(TreeNode root) {
        aux_longestZigZag(root);
        return max;
    }

    public int[] aux_longestZigZag(TreeNode root) {
        int[] temp=new int[2];
        if (root==null){
            temp[0]=-1;
            temp[1]=-1;
            return temp;
        }
        int[] left=aux_longestZigZag(root.left);
        int[] right=aux_longestZigZag(root.right);
        temp[0]=left[1]+1;
        temp[1]=right[0]+1;
        max=Math.max(max,Math.max(temp[0],temp[1]));
        return temp;
    }

}
