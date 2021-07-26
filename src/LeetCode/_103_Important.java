package LeetCode;

import java.util.ArrayList;
import java.util.List;

//还是那个思路,递归查看左右子树,处理好叶子节点和空节点
//这题的思路就是递归查看左右子树,得到左右子树的List,然后先加入根节点,再合并左右子树的list,合并的时候要注意这层的高度,根据不同的高度决定合并顺序
//然后多余的部分直接加入
public class _103_Important {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=aux_zigzagLevelOrder(root,0);
        return result;
    }

    public List<List<Integer>> aux_zigzagLevelOrder(TreeNode root,int high) {
          if (root==null){
              return new ArrayList<List<Integer>>();
          }
        List<List<Integer>> left=aux_zigzagLevelOrder(root.left,high+1);
        List<List<Integer>> right=aux_zigzagLevelOrder(root.right,high+1);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.get(0).add(root.val);
        int flag=high%2;
        for (int i = 0; i <Math.min(left.size(),right.size()) ; i++) {
            List<Integer> tempL=left.get(i);
            List<Integer> tempR=right.get(i);
            if (flag==1){
                tempL.addAll(tempR);
                result.add(tempL);
            }
            else {
                tempR.addAll(tempL);
                result.add(tempR);
            }
            flag=(flag+1)%2;
        }
        for (int i = Math.min(left.size(),right.size()); i <Math.max(left.size(),right.size()) ; i++) {
                if (left.size()==Math.max(left.size(),right.size())){
                    result.add(left.get(i));
                }
                else {
                    result.add(right.get(i));
                }
        }
        return result;
    }
}
