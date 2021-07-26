package LeetCode;

import java.util.*;
//我的思路就是采用后序遍历,把左右子树的每个节点都放入一个集合中,然后对于左边的每一个节点都去和右边的每一个节点比较一次序列
//但其实没有必要,直接用一个set保存所有序列化的String对象就可以,每当有一个新的序列就看看是否已经存在了
//整体思路是差不多的,都是把空节点的值设为#,然后序列化,只是不需要把节点都加入集合
public class _652_important {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
/*************优秀解法******************/
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (root == null) return res;
        saveRoute(root, res, map);
        return res;
    }

    //递归获取每个子树的路径，保存于Map中
    private String saveRoute(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
        if (node == null) return "";
        //自底向上获取每个节点的序列化值
        String route = node.val + "," + saveRoute(node.left, res, map) + "," + saveRoute(node.right, res, map);
        //将结果放入map，判断是否有相同子树
        //避免出现多次相同子树
        if (map.get(route) != null && map.get(route) == 1) {
            res.add(node);
        }
        //map.getOrDefault就是如果有就用对应的值,如果没有就用自己设的默认值
        map.put(route, map.getOrDefault(route, 0) + 1);
        return route;
    }
    /*************优秀解法结束******************/


    HashMap<TreeNode,String> result=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        aux_findDuplicateSubtrees(root);
        List<TreeNode> finalResult = new LinkedList<>();
        finalResult.addAll(result.keySet());
        return finalResult;
    }
    public HashMap<TreeNode,String> aux_findDuplicateSubtrees(TreeNode root) {
        if (root==null){
            return new HashMap<>();
        }
        if (root.left==null&&root.right!=null){
            HashMap<TreeNode,String> right=aux_findDuplicateSubtrees(root.right);
            String mid="#,"+root.val+","+right.get(root.right);
            right.put(root,mid);
            return right;
        }
        if (root.left!=null&&root.right==null){
            HashMap<TreeNode,String> left=aux_findDuplicateSubtrees(root.left);
            String mid=left.get(root.left)+",#,"+root.val;
            left.put(root,mid);
            return left;
        }
        if (root.left==null&&root.right==null){
            HashMap<TreeNode,String> m=new HashMap<>();
            String mid="#,#,"+root.val;
            m.put(root,mid);
            return m;
        }
        HashMap<TreeNode,String> left=aux_findDuplicateSubtrees(root.left);
        HashMap<TreeNode,String> right=aux_findDuplicateSubtrees(root.right);
        for (TreeNode x:left.keySet()){
            for (TreeNode y:right.keySet()){
                if (left.get(x).equals(right.get(y))&&!result.containsValue(left.get(x))){
                    result.put(x,left.get(x));
                    break;
                }
            }
        }
        left.putAll(right);
        String mid=left.get(root.left)+","+left.get(root.right)+","+root.val;
        left.put(root,mid);

        return left;
    }
}
