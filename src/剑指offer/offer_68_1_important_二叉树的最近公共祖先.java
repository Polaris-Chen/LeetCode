package 剑指offer;

public class offer_68_1_important_二叉树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //这个代码量小得多但是逻辑比较难理解 要仔细理解一下
    //该方法的定义就是在以root为根的树中找到p,q的最近公共祖先，牢记这个定义
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果根节点就匹配到了 就不需要下去找了，因为不管在下面的哪个位置他们俩的祖先都是根节点
        if (root == p || root == q) {
            return root;
        }
        //接下来只有三种情况  要么最近公共祖先在左子树，要么在右子树，要么pq刚好分布在左右子树，这时最近公共祖先就是root
        //千万不要忘了自己的定义 该方法就是会返回以root为根的树中找到p,q的最近公共祖先，所以啥也别管，直接把左右子树放进去
        //如果找不到，那就返回空了
        TreeNode left=lowestCommonAncestor1(root.left,p,q);
        TreeNode right=lowestCommonAncestor1(root.right,p,q);
        //如果都不空，那祖先就是根节点了
        if (left!=null&&right!=null){
            return root;
        }
        //谁不空返回谁
        return left!=null? left:right;
    }
}
