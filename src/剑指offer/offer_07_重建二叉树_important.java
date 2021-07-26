package 剑指offer;

import java.util.HashMap;
/*输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。*/
public class offer_07_重建二叉树_important {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, 0, inorder.length, map);
    }

    //我的核心思路其实就是在前序遍历数组中找到根节点,就是第一个,然后递归的对左右子树重组就行,一个必须知道的数目是左子树有多少个节点,这个数目就需要去中序遍历里找
    // p_start, p_end,i_start,  i_end用来分割两个数组  都是前开后闭

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int i_start, int i_end,
                                     HashMap<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        //前序遍历数组中的第一个就是根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //用一个hashmap就能直接找到根节点在中序遍历中所在的位置
        int i_root_index = map.get(root_val);
        //算出左子树共有几个节点
        int leftNum = i_root_index - i_start;
        //左子树范围就是 p_start + 1(除掉根节点) 到p_start + leftNum + 1(加上左子树的数目)  中序遍历中也同理
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end,  i_root_index + 1, i_end, map);
        return root;
    }




















    //递归的求出左子树和右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          //如果长度为0就直接返回空值
          if (preorder.length==0){
              return null;
          }
          //如果是叶子节点就返回单节点
          else if (preorder.length==1){
              return new TreeNode(preorder[0]);
          }
          //否则就对这棵树的左右子树进行递归遍历
        //先找到根节点,必定是preorder的第一个数
        TreeNode root=new TreeNode(preorder[0]);
          //然后对其进行划分,根据根节点在中序中分出左右子树
        int leftLength=leftLenth(inorder,root.val);
        int[] leftTreePreorder=split(preorder,1,1+leftLength);
        int[] lefttTreeInorder=split(inorder,0,leftLength);
        int[] rightTreePreorder=split(preorder,leftLength+1,preorder.length);
        int[] rightTreeInorder=split(inorder,leftLength+1,preorder.length);

        //递归调用方法
        root.left=buildTree(leftTreePreorder,lefttTreeInorder);
        root.right=buildTree(rightTreePreorder,rightTreeInorder);

        return root;
    }
    //分割数组的辅助方法
    public int[] split(int[] a,int left,int right){//前开后闭的范围
          int[] newa=new int[right-left];

          int j=0;
          for (int i=left;i<right;i++){
              newa[j]=a[i];
              j++;
          }
          return newa;
    }
    //求左子树节点个数的辅助方法
    public int leftLenth(int[] a,int mid){
          int leftLength=0;
          for (int i=0;i<a.length;i++){
              if (a[i]==mid){
                  break;
              }
              else {
                  leftLength++;
              }
          }
          return leftLength;
    }

    public static void main(String[] args) {
        offer_07_重建二叉树_important a=new offer_07_重建二叉树_important();
        TreeNode root=a.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        for (int i=0;i<3;i++){
            System.out.println(root.val);
            root=root.right;
        }
    }
}
