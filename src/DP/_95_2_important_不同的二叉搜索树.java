package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polarisChen
 * @create 2021/5/4 10:35 下午
 *
 * 思路和96还是比较像的,都有对于某一段数字,逐一将这段数字中的每一个作为根
 * 但是这里采用一个递归的思想,比如第i个作为根节点,就分别对他的左右部分再进行递归
 * 递归出口是在左边界大于右边界的时候,加入一个null节点
 */
public class _95_2_important_不同的二叉搜索树 {
    public class TreeNode {
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

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<>();
        }
        return aux_generateTrees(1,n);
    }

    public List<TreeNode> aux_generateTrees(int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if (start>end){
            result.add(null);
            return result;
        }

        for (int i = start; i <=end  ; i++) {
            List<TreeNode> left=aux_generateTrees(start,i-1);
            List<TreeNode> right=aux_generateTrees(i+1,end);

            for (TreeNode leftNode:left){
                for (TreeNode rightNode:right){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    result.add(root);
                }
            }
        }
        return  result;
    }
}
