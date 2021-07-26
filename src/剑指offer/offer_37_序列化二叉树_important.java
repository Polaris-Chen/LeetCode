package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_37_序列化二叉树_important {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//序列化就是要注意把空节点也加入进去
    public String serialize(TreeNode root) {
      //StringBuilder可以大大加速字符串拼接的速度
      StringBuilder result= new StringBuilder();
      if (root==null){
        return result.toString();
      }
      Queue<TreeNode> q=new LinkedList<>();
      q.add(root);
      while (!q.isEmpty()){
        TreeNode temp=q.poll();
        if (temp!=null){
          q.add(temp.left);
          q.add(temp.right);
          result.append(temp.val).append(",");
        }
        else {
          result.append("null,");
        }
      }
      System.out.println(result.substring(0,result.length()-1));
      return result.substring(0,result.length()-1);
    }

    // 反序列化就是根据数组中的值一个个生成节点
    public TreeNode deserialize(String data) {
      if (data.equals("")){
        return null;
      }
      String[] tree=data.split(",");
      TreeNode root=new TreeNode(Integer.parseInt(tree[0]));
      Queue<TreeNode> line=new LinkedList<>();
      line.add(root);
      int x=1;
      while (!line.isEmpty()){

          TreeNode temp=line.poll();
          if (!tree[x].equals("null")){
            temp.left=new TreeNode(Integer.parseInt(tree[x]));
            line.add(temp.left);
          }
          x++;
          if (!tree[x].equals("null")){
            temp.right=new TreeNode(Integer.parseInt(tree[x]));
            line.add(temp.right);
          }
          x++;
        }
      return root;
    }
}
