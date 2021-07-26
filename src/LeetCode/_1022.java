package LeetCode;

import java.util.ArrayList;

public class _1022 {
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
    public int sumRootToLeaf(TreeNode root) {
        String nowRoad="";
        ArrayList<String> road=new ArrayList<>();
        aux_sumRootToLeaf(root,road,nowRoad);
        int sum=0;
        for (String x:road){
            sum+=sum(x);
        }
        return sum;
    }
    public int sum(String x){
          int j=0;
        double result=0.0;
        for (int i = x.length()-1; i>=0; i--) {
            if (x.charAt(i)=='1') {
                 result+= Math.pow(2.0, j);
            }
            j++;
        }
        return (int)result;
    }

    public void aux_sumRootToLeaf(TreeNode root, ArrayList<String> road,String nowRoad) {

          if (root==null){
              return;
          }
          nowRoad+=root.val;
        if (root.left==null&&root.right==null){
            road.add(nowRoad);
        }
        String nowRoadLeft=nowRoad;
        String nowRoadRight=nowRoad;
        aux_sumRootToLeaf(root.left,road,nowRoadLeft);
        aux_sumRootToLeaf(root.right,road,nowRoadRight);


    }
}
