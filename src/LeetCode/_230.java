package LeetCode;

import java.util.ArrayList;

public class _230 {

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
    ArrayList<Integer> t=new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        aux_kthSmallest(root,k);
        return t.get(k-1);
    }
    public void aux_kthSmallest(TreeNode root, int k) {
        if (root==null){
            return;
        }
        aux_kthSmallest(root.left,k);
        if (t.size()<k){
            t.add(root.val);
        }
        else {
            return;
        }
        aux_kthSmallest(root.right,k);
    }
}
