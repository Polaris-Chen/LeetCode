package LeetCode;

public class _897 {
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
    public TreeNode increasingBST(TreeNode root) {
        if (root==null){
            return null;
        }
        else if(root.left==null&&root.right==null){
            return root;
        }

        TreeNode newRoot=increasingBST(root.left);
        if (newRoot!=null){
            TreeNode temp=newRoot;
            while (temp.right!=null){
                temp= temp.right;
            }
            temp.right=new TreeNode(root.val);
            temp.right.right=increasingBST(root.right);
        }
        else {
            newRoot=new TreeNode(root.val);
            newRoot.right=increasingBST(root.right);
        }
        return  newRoot;
    }
}
