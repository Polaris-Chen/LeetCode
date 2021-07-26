package LeetCode;
//还是使用递归的方法,先把左右子树少的部分都由左右子树的根节点先欠着,并把全局变量sum加上移动次数
//最后再处理根节点和左右节点
//也就是从叶子节点开始,如果多的就交给根节点,如果不够就从根节点借,根节点自己没有也没关系
//反正先给叶子,因为就算是从别的地方转过来,也是要通过根节点的
//这样就把左右子树欠的和多的都算出来,最后和最根的根节点的值比较一下得出最后的次数
public class _979_important {
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
    public int distributeCoins(TreeNode root) {
        //如果左右子树不为空,就去让他们汇聚到左右子树的根节点
        //如果为空那就搞一个已经平衡的子树给他,不然后面不好算
        if (root.left!=null) {
            aux_distributeCoins(root.left);
        }
        else {
            root.left=new TreeNode(1);
        }
        if (root.right!=null) {
            aux_distributeCoins(root.right);
        }
        else {
            root.right=new TreeNode(1);
        }
        int left=root.left.val;
        int right=root.right.val;

        //如果左右都比1大或者比1小,那就不用相互给,直接由根节点分配就行
        if ((left<1&&right<1)||(left>1&&right>1)){
            return Math.abs(root.val-1)+sum;
        }
        //如果一个大于1一个小于1就要再分两组情况
        else {
            //如果根节点不是0 那就不需要分给根节点 直接把多的部分给少的那边,这里要移动2次,然后根节点多的再给少的那边,这里是1次
            if (root.val!=0) {
                    return sum + root.val - 1 + (Math.max(root.left.val, root.right.val) - 1) * 2;
            }
            //如果根节点是0,那就直接给根节点1个,然后其他移动就行了
            else {
                return sum+(Math.max(root.left.val,root.right.val)-1)*2-1;
            }
        }

    }

    public void aux_distributeCoins(TreeNode root) {
        if (root==null){
            return;
        }
        aux_distributeCoins(root.left);
        aux_distributeCoins(root.right);
        if (root.left!=null){
            root.val+=root.left.val-1;
            sum+=Math.abs(root.left.val-1);
        }
        if (root.right!=null){
            root.val+=root.right.val-1;
            sum+=Math.abs(root.right.val-1);
        }

    }
}
