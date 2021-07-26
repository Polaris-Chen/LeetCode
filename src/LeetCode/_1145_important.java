package LeetCode;
//思路其实很简单,不要被题目吓到了,其实就是沿着三个方向去统计节点个数,父节点那边还提供了总结点数
//直接减就可以了,所以仔细分析就行
public class _1145_important {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode user1=find(root,x);
        int left=count(user1.left);
        int right=count(user1.right);
        int father=n-left-right-1;
        if (left>father+right||right>left+father||father>left+right){
            return true;
        }
        else {
            return false;
        }

    }

    public int count(TreeNode root){
          if (root==null){
              return 0;
          }

          int left=count(root.left);
          int right=count(root.right);
          return left+right+1;

    }
    public TreeNode find(TreeNode root,int val){
       if (root==null){
           return new TreeNode(0);
       }

        if (root.val==val){
            return root;
        }
        TreeNode left=find(root.left,val);
        TreeNode right=find(root.right,val);
        if (left.val!=0){
            return left;
        }
        else if (right.val!=0){
            return right;
        }
        else {
            return new TreeNode(0);
        }
    }

}
