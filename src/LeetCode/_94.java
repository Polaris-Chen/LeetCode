package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _94 {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree=new ArrayList<>();
        if (root==null){
            return tree;
        }
        aux_inorderTraversal(root,tree);
        return tree;
    }
    public void aux_inorderTraversal(TreeNode root, List<Integer> treeList) {
          if (root==null){
              return;
          }
          aux_inorderTraversal(root.left,treeList);
          treeList.add(root.val);
          aux_inorderTraversal(root.right,treeList);
    }
}
