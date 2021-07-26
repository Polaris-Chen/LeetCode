package LeetCode;

import java.util.Arrays;
//我的基础思路就是递归的查看左右子树,把左子树里的好叶子节点数目加上右子树里的再加上横跨左右子树的
public class _1530_Important {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        if(distance==1){
            return 0;
        }
        int[] x=aux_countPairs(root,distance);
        System.out.println(x[2]);
        return x[0];
    }

    public int[] aux_countPairs(TreeNode root, int distance) {
        if (isLeaf(root)==1){
            return new int[distance];
        }
        int[] left=new int[distance],right=new int[distance],result=new int[distance];
        if (root.left!=null) {
            left = aux_countPairs(root.left, distance);
            System.out.println(Arrays.toString(left) +" left:"+root.left.val);
        }

        if (root.right!=null) {
            right=aux_countPairs(root.right,distance);
            System.out.println(Arrays.toString(right) +" right:"+root.right.val);
        }



        for (int i = distance-1; i >1 ; i--) {
            left[i]=left[i-1];
            right[i]=right[i-1];
        }

        left[1]=isLeaf(root.left);
        right[1]=isLeaf(root.right);
        result[0]=sum(left,right,distance)+left[0]+right[0];
        for (int i = 1; i <distance ; i++) {
            result[i]=left[i]+right[i];
        }
        System.out.println(Arrays.toString(result) +" root:"+root.val);
        return result;
    }

    public int isLeaf(TreeNode x){
        if (x==null){
            return 0;
        }
        if (x.left==null&&x.right==null){
            return 1;
        }
        return 0;
    }

    public int sum(int[] a,int[] b,int distance){
        int sum=0;
        for (int i = 1; i <distance ; i++) {
            for (int j = distance-i; j >0; j--) {
                sum+=a[i]*b[j];
            }
        }
        System.out.println("sum"+sum);
        return sum;
    }
}
