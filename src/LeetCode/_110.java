package LeetCode;
//迭代计算左右子树的高度,一旦出现不平衡就直接全返回-1,不然就返回左右子树中的最大深度,,唯一的问题就是要确认好叶子节点,空节点,非叶子节点对应的值
public class _110 {
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

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }

        if (aux_isBalanced(root)!=-1){
            return true;
        }
        else {
            return false;
        }
    }
    public int aux_isBalanced(TreeNode root) {
        if (root==null){
              return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=aux_isBalanced(root.left);
        int right=aux_isBalanced(root.right);

        if (left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        else {
            return Math.max(left,right)+1;
        }
    }
}
