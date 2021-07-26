package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer_32_2 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

  }
    public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> q=new LinkedList<>();
      List<List<Integer>> end=new ArrayList<>();
      q.add(root);
      while (!q.isEmpty()){
        int size=q.size();
        List<Integer> line=new ArrayList<>();
        for (int i = 0; i <size ; i++) {
          TreeNode temp=q.poll();
          line.add(temp.val);
          if (temp.left!=null){
            q.add(temp.left);
          }
          if (temp.right!=null){
            q.add(temp.right);
          }
        }
        end.add(line);
      }
      return end;
    }
}
