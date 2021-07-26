package LeetCode;
import java.util.HashSet;
import java.util.Set;
//可以将数值转换成2进制,看是0还是1 会更快一点
public class _1261 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class FindElements {
        TreeNode root;
        Set<Integer> value;
        public FindElements(TreeNode root) {
            value=new HashSet<>();
            root.val=0;
            aux_FindElements(root);
            this.root=root;

        }
        public void aux_FindElements(TreeNode root) {
            if (root==null){
                return;
            }
            if (root.left!=null){
                root.left.val=root.val*2+1;
                value.add(root.left.val);
                aux_FindElements(root.left);
            }
            if (root.right!=null){
                root.right.val=root.val*2+2;
                System.out.println(root.right.val);
                value.add(root.right.val);
                aux_FindElements(root.right);
            }


        }

        public boolean find(int target) {
            return value.contains(target);
        }
    }
}
