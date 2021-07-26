package LeetCode;
//简单递归
public class _654 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return aux_constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode aux_constructMaximumBinaryTree(int[] nums,int l,int r) {
      if (l>r){
        return null;
      }
      else if (l==r){
        return new TreeNode(nums[l]);
      }

      int mid=findMax(nums,l,r);
      TreeNode root=new TreeNode(nums[mid]);
      root.left=aux_constructMaximumBinaryTree(nums,l,mid-1);
      root.right=aux_constructMaximumBinaryTree(nums,mid+1,r);

      return root;
    }


    public int findMax(int[] nums,int l,int r){
      int max=l;
      for (int i = l+1; i <r+1 ; i++) {
        if (nums[i]>nums[max]){
          max=i;
        }
      }
      return max;
    }
}
