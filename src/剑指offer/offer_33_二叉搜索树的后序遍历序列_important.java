package 剑指offer;
//想法其实也不复杂,我第一次也想到了,但是我太注重细节了
//陷进细节里了,其实就是简简单单判断一下能不能划分出左右树,然后再递归处理左右树
public class offer_33_二叉搜索树的后序遍历序列_important {
    public boolean verifyPostorder(int[] postorder) {
          return   aux_verifyPostorder(postorder,0,postorder.length-1);

    }
    public boolean aux_verifyPostorder(int[] postorder,int l,int r) {
        System.out.println(l+" "+r);
        if (l>=r){
            return true;
        }
        int root=postorder[r];
        int i=l;
        while (postorder[i]<root){
            i++;
        }
        int x=i;//i为右子树的第一个
        while (postorder[x]>root){
            x++;
        }
        return x==r&&aux_verifyPostorder(postorder,l,i-1)
                &&aux_verifyPostorder(postorder,i,r-1);

    }
}
