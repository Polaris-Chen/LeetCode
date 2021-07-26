package LeetCode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_important {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> nodes=new ArrayList<>();
      Queue<TreeNode> q=new LinkedList<>();
      if (root!=null){
            q.add(root);
      }
      while (!q.isEmpty()){
          int n=q.size();
          List<Integer> node=new ArrayList<>();
          for (int i = 0; i < n; i++) {
              TreeNode temp=q.poll();
              if (temp.left!=null){
                  q.add(temp.left);
              }
              if (temp.right!=null){
                  q.add(temp.right);
              }
              node.add(temp.val);
          }

          nodes.add(node);
      }
      return nodes;
    }
}
