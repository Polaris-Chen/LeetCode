package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer_32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        List<Integer> fin=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode temp=q.poll();
            if (temp.left!=null){
                q.add(temp.left);
            }
            if (temp.right!=null){
                q.add(temp.right);
            }
            fin.add(temp.val);
        }
        int[] result=new int[fin.size()];
        for (int i = 0; i <fin.size(); i++) {
            result[i]=fin.get(i);
        }
        return result;
    }
}
