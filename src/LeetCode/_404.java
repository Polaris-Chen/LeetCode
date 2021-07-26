package LeetCode;

public class _404 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  int sum=0;
 public int sumOfLeftLeaves(TreeNode root) {
        aux_sumOfLeftLeaves(root);
        return sum;
 }
    public void aux_sumOfLeftLeaves(TreeNode root) {

            if (root==null){
                return;
            }
            if (root.left!=null&&root.left.left==null&&root.left.right==null){
                sum+=root.left.val;
            }

            aux_sumOfLeftLeaves(root.left);
            aux_sumOfLeftLeaves(root.right);
    }
}
