package LeetCode;
//还是迭代的去看左右子树，如果左右一样大，那肯定返回根节点，如果不一样大，那小的一边可以直接删了，再遍历大的那边
//虽然看起来做了很多次重复操作，但是只是计算高度其实速度还挺快的
public class _1123_important {

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

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left=aux_lcaDeepestLeaves(root.left);
        int right=aux_lcaDeepestLeaves(root.right);
        if (left==right){
            return root;
        }
        else if (left>right){
           return lcaDeepestLeaves(root.left);
        }
        else {
           return lcaDeepestLeaves(root.right);
        }
    }

    public int  aux_lcaDeepestLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(aux_lcaDeepestLeaves(root.left),aux_lcaDeepestLeaves(root.right))+1;
    }
}
