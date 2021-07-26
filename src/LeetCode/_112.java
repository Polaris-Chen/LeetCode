package LeetCode;

public class _112 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            return sum==root.val;
        }
        boolean left=hasPathSum(root.left,sum-root.val);
        boolean right=hasPathSum(root.right,sum-root.val);

        return left||right;
    }
}
