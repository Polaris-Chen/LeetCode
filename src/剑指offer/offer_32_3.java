package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer_32_3 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int flag=1;

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
            if (flag==-1){
                line= change(line);
            }
            result.add(line);
            flag=-flag;
        }
        return result;
    }

    public List<Integer> change(List<Integer> line){
        List<Integer> changeList=new ArrayList<>();
        for (int i = line.size()-1; i >=0 ; i--) {
            changeList.add(line.get(i));
        }
        return changeList;
    }
}
