package LeetCode;
//不断走右子树
public class _998 {

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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode q=root;
        if (root.val<val){
            TreeNode newRoot=new TreeNode(val,root,null);
            return newRoot;
        }

        while (q!=null){
            if (q.right==null){
                q.right=new TreeNode(val);
                return root;
            }
            if (q.right.val>val) {
                q = q.right;
                continue;
            }
            break;
        }
        q.right=new TreeNode(val,q.right,null);
        return root;
    }
}
