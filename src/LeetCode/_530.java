package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polarisChen
 * @create 2021/7/9 12:46 下午
 */
public class _530 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> x=new ArrayList<>();
        aux(root,x);
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <x.size() ; i++) {
            if (x.get(i)-x.get(i-1)<min){
                min=x.get(i)-x.get(i-1);
            }
        }
        return min;
    }

    public void aux(TreeNode root, List<Integer> re){
        if (root==null){
            return;
        }
        aux(root.left,re);
        re.add(root.val);
        aux(root.right,re);
    }
}
