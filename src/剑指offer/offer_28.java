package 剑指offer;

public class offer_28 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return  aux_isSymmetric(root.left,root.right);
    }
    public boolean aux_isSymmetric(TreeNode left,TreeNode right) {
        if ((left!=null&&right==null)||(left==null&&right!=null)){
            return false;
        }
        if(left==null&&right==null){
            return true;
        }
        if (left.val==right.val){
            return aux_isSymmetric(left.left,right.right)&&aux_isSymmetric(left.right,right.left);
        }
        else {
            return false;
        }
    }
}
