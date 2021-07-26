package 剑指offer;
//这题的核心就是要捋清思路,首先要看以root为根的A树能不能和B树匹配,
// 再迭代看看以root的左右子树为根的A树能不能匹配
//然后能不能匹配则要再搞一个方法,因为又要迭代查看左右节点的val值是否匹配
public class offer_26_树的子结构_important {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A==null||B==null){
        return false;
    }
   return aux_isSubStructure(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean aux_isSubStructure(TreeNode A, TreeNode B) {
          //如果B为空证明到底了,因为B的每一个点都没有发现值不同,也就是一直没有进入下面那个if
          if (B==null){
              return true;
          }
          //如果A空B不空或者值不同,就不用看了
          if (A==null||A.val != B.val){
              return false;
          }
          return aux_isSubStructure(A.left,B.left)&&aux_isSubStructure(A.right,B.right);
    }
}
