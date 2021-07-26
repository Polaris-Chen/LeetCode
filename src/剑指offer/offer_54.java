package 剑指offer;

import java.util.ArrayList;

public class offer_54 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  int t=0;
  int result=0;
    public int kthLargest(TreeNode root, int k) {
        aux_kthLargest(root,k);
        return result;
    }
    public void aux_kthLargest(TreeNode root, int k) {
        if (root==null){
            return;
        }
        aux_kthLargest(root.right,k);
        t++;
        if (t==k){
            result=root.val;
            return;
        }
        aux_kthLargest(root.left,k);
    }
}
