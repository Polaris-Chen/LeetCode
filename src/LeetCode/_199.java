package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//使用层次遍历,确认每层的最后一个元素
//也可以使用深搜,优先访问右边的树,当新到达一层时第一个访问的一定是最右边的
public class _199 {

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nums=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int length=queue.size();
            for (int i = 0; i <length ; i++) {
                TreeNode x=queue.poll();
                if (x.left!=null){
                    queue.add(x.left);
                }
                if (x.right!=null){
                    queue.add(x.right);
                }

                if (i==length-1){
                    nums.add(x.val);
                }
            }
        }
        return nums;
    }
}
