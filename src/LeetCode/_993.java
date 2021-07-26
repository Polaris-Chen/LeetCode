package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _993 {
      public static class TreeNode {
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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        if (root!=null) {
            q.add(root);
        }
        while (!q.isEmpty()){
            int i=q.size();
            int flag=0;
            for (int j = 0; j <i; j++) {
                int interFlag=0;
                TreeNode temp=q.poll();
                if (temp.left!=null){
                    q.add(temp.left);
                    if (temp.left.val==x||temp.left.val==y){
                        flag++;
                        interFlag++;
                    }
                }
                if (temp.right!=null){
                    q.add(temp.right);
                    if ((temp.right.val==x||temp.right.val==y)&&interFlag==0){
                        flag++;
                        System.out.println("11");
                    }
                }

            }
            if (flag==2){
                return true;
            }

        }
        return false;
    }
}
