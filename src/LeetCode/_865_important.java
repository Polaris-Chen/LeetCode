package LeetCode;
//我自己的想法非常巧妙,如果左右一样高,那肯定最近祖先是这个根节点,如果不一样高,那就直接删了根节点
//和另一边,去高的那边找
//也可以转换成最深叶节点的最近公共祖先问题,也是一模一样的
public class _865_important {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {


            int left = aux_height(root.left);
            int right = aux_height(root.right);
            if (left == right) {
                return root;
            } else if (left > right) {
                return subtreeWithAllDeepest(root.left);
            } else {
                return subtreeWithAllDeepest(root.right);
            }
        }

        public int aux_height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = aux_height(root.left);
            int right = aux_height(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
