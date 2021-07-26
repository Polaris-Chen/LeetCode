package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class offer_34 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<Integer> road=new ArrayList<>();
    aux_pathSum(root,sum,road);
    return result;
    }
    public void  aux_pathSum(TreeNode root, int sum,List<Integer> road) {
        if (root==null){
            return;
        }


             if (sum==root.val&&root.left==null&&root.right==null){
                road.add(root.val);
                result.add(road);
                road.remove(road.size()-1);
            }
            else {
                road.add(root.val);
                List<Integer> left = new ArrayList<>(road);
                aux_pathSum(root.left,sum-root.val,left);
                aux_pathSum(root.right,sum-root.val,road);
            }
    }
}
