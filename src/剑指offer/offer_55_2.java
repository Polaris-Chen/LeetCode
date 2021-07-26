package 剑指offer;

public class offer_55_2 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isBalanced(TreeNode root) {
      int[] x=aux_isBalanced(root);
      return x[1] != 1;
    }

    public int[] aux_isBalanced(TreeNode root) {
      if (root==null){
        return new int[]{0,0};
      }
      int[] left=aux_isBalanced(root.left);
      int[] right=aux_isBalanced(root.right);
      if (left[1]==1||right[1]==1){
        return new int[]{0,1};
      }
      else {
        if (Math.abs(left[0]-right[0])<2) {
          return new int[]{Math.max(left[0], right[0]) + 1, 0};
        }
        else {
          return new int[]{0,1};
        }
      }
    }
}
