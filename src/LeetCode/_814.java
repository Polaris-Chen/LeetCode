package LeetCode;

public class _814 {
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
    public TreeNode pruneTree(TreeNode root) {
        aux_pruneTree(root.left,root);
        aux_pruneTree(root.right,root);
        if (root.val==0&&root.left==null&&root.right==null){
            return null;
        }
        return root;
    }

    public boolean aux_pruneTree(TreeNode root,TreeNode rootFather) { //true= no 1
        if (root==null){
            return true;
        }
        boolean left=aux_pruneTree(root.left,root);
        boolean right=aux_pruneTree(root.right,root);
        if (left&&right&&root.val==0){
            if (rootFather.left!=null&&rootFather.left.equals(root)){
                rootFather.left=null;
                System.out.println("??");
            }
            else {
                rootFather.right=null;
            }

            return true;
        }
        return false;
    }
}
