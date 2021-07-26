package LeetCode;
//二叉搜索树的最大特点就是中序遍历的结果是一个升序数组,所以不能像之前考虑二叉树一样总是想着左右根
//这题就是采用右根左的顺序,不断累加sum,其实思路非常简单,就是我还不熟悉二叉搜索树
public class _538_important {
    public class TreeNode {
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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
            aux_convertBST(root);
            return root;
    }

    public void  aux_convertBST(TreeNode root) {
        if (root==null){
            return;
        }
        aux_convertBST(root.right);
        root.val+=sum;
        sum=root.val;
        aux_convertBST(root.left);
    }
}
