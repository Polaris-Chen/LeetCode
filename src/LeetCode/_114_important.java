package LeetCode;
//其实就是递归的思想 逐步转化左右节点
public class _114_important {
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
    public void flatten(TreeNode root) {
        aux_flatten(root);
    }
    public void aux_flatten(TreeNode root) {
          if (root==null){
              return;
          }
        aux_flatten(root.left);
        aux_flatten(root.right);
        if (root.left!=null) {
            TreeNode p = root.left;

            while (p.right != null) {
                p = p.right;
            }
            p.right = root.right;
            root.right=root.left;
            root.left=null;
        }


    }
}
