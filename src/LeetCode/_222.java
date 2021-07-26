package LeetCode;

public class _222 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int countNodes(TreeNode root) {
          if (root==null){
              return 0;
          }
          if (root.left==null&&root.right==null){
              return 1;
          }
        int left=countNodes(root.left);
        int right=countNodes(root.right);
        return left+right+1;
    }

}
