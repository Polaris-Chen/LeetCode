package LeetCode;
//我的基础思路就是遍历整棵树,并且标记已经走过的路,下次再走就不会重复计算了
public class _1372 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int longestZigZag(TreeNode root) {
          if (root==null){
              return 0;
          }
          //往左走和往右走的最大收益
        int left=aux_aux__longestZigZag(root,1);
        int right=aux_aux__longestZigZag(root,-1);
        int result=Math.max(left,right);
        //以左子树为根和以右子树为根的最大收益
        int Max=Math.max(longestZigZag(root.left),longestZigZag(root.right));
        return Math.max(result,Max);
    }
    //way代表了root之前的方向,1为右,-1为左
    public int aux_aux__longestZigZag(TreeNode root,int way) {
          TreeNode temp=root;
          int road=0;
            while (temp!=null){
                //如果之前是往右,那么这里就往左
                if (way==1){
                    //当且仅当左边不为空且没访问过
                    if (temp.left!=null&&temp.left.val!=-1) {
                        temp = temp.left;
                        //转换方向且标记节点
                        temp.val=-1;
                        way=-1;
                    }
                    else {
                        break;
                    }

                }
                else {
                    if (temp.right!=null&&temp.right.val!=-1) {
                        temp = temp.right;
                        temp.val=-1;
                        way = 1;
                    }
                    else {
                        break;
                    }
                }
                road++;
            }
            return road;
    }
}
