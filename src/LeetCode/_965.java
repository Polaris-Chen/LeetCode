package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class _965 {

     public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isUnivalTree(TreeNode root) {
         if (root==null){
             return false;
         }
        int i=root.val;
       return aux_isUnivalTree(i,root);
    }
    public boolean aux_isUnivalTree(int i,TreeNode root) {
       if (root==null){
           return true;
       }

        if (root.val==i){
            return aux_isUnivalTree(i,root.left)&&aux_isUnivalTree(i,root.right);
        }
        else {
            return false;
        }
    }
}
