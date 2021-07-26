package 剑指offer;

import java.util.ArrayList;
import java.util.List;
//一个是最容易想到的办法 查找节点并记录路径 最后比较路径找到公共祖先
public class offer_68_2_important_二叉搜索树的最近公共祖先 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> proad=new ArrayList<>();
        List<TreeNode> qroad=new ArrayList<>();
        aux_lowestCommonAncestor(root,p,proad);
        aux_lowestCommonAncestor(root,q,qroad);
        TreeNode result=new TreeNode(0);

        for (int i = 0; i <Math.min(proad.size(),qroad.size()) ; i++) {
            if (proad.get(i)!=qroad.get(i)){
                result=proad.get(i-1);
                break;
            }
            //如果比较到最后还是一样 那么这个最后一个就是公共祖先
            if (i ==Math.min(proad.size(),qroad.size())-1){
                result=proad.get(i);
            }
        }
        return result;
    }

    public void aux_lowestCommonAncestor(TreeNode root, TreeNode p,List<TreeNode> road) {
        road.add(root);
        if (root.val==p.val){
               return;
        }
        else if (root.val>p.val){
            aux_lowestCommonAncestor(root.left,p,road);
        }
        else {
            aux_lowestCommonAncestor(root.right,p,road);
        }

    }
//速度更快 ，但是逻辑也需要盘一盘
    //该方法的定义就是在以root为根的树中找到p,q的最近公共祖先，牢记这个定义
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        // 如果根节点就匹配到了 就不需要下去找了，因为不管在下面的哪个位置他们俩的祖先都是根节点
        if (root==p||root==q){
            return root;
        }
        //根据二叉搜索树的性质进行剪枝
        if (root.val<Math.min(p.val,q.val)){
            return lowestCommonAncestor1(root.right,p,q);
        }
        if (root.val>Math.max(p.val,q.val)){
            return lowestCommonAncestor1(root.left,p,q);
        }
        //此时牢记定义,直接左右子树带进去就好
        TreeNode left=lowestCommonAncestor1(root.left,p,q);
        TreeNode right=lowestCommonAncestor1(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }

        return left!=null? left:right;
    }



}
