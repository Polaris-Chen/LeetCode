package LeetCode;

import java.util.ArrayList;

//优化后的思路就是先把所有叶子节点的路径都求出来,放在result里,然后一个个比较,看看distance是多少,他们之间的路径就是,两者的总路径剪去重合的长度

public class _1530_opt {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2,new TreeNode(3),new TreeNode(4));

        _1530_opt a=new _1530_opt();
        a.countPairs(root,2);
    }
    public int countPairs(TreeNode root, int distance) {
        if(distance==1){
            return 0;
        }
        //路径数组
        ArrayList<Integer> road =new ArrayList<Integer>();
        //叶子节点数组
        ArrayList<Integer[]> result=new ArrayList<Integer[]>();
        aux_countPairs(root,road,result);
        int sum=0;
        //对每一对叶子节点进行判断
        for (int i = 0; i <result.size()-1 ; i++) {
            for (int j = i+1; j <result.size(); j++) {
                if (compare(result.get(i),result.get(j),distance)){
                    sum++;
                }
            }
        }

        return sum;
    }

    //判断函数
    Boolean compare(Integer[] a,Integer[] b, int distance){
        int i=-1;
        int flag=0;
        while (i!=a.length||i!=b.length){

                if (!a[i+1].equals(b[i+1])){
                   flag=1;
                   break;

                }
                i++;
        }

        //0的时候代表是因为长度不足结束的,需要i--
        if (flag==0){
            i--;
        }
        //-1的时候证明第一个数就不相同
        if (i==-1){
            return distance>a.length+b.length;
        }
        if (distance<Math.abs(a.length+b.length-i*2)){
            return false;
        }
        else {
            return true;
        }

    }
    void aux_countPairs(TreeNode root,ArrayList<Integer> road,ArrayList<Integer[]> result) {
        if (isLeaf(root)==1){
            result.add(road.toArray(new Integer[road.size()]));
        }
        if (root==null){
            return;
        }
        //左子树为1 右子树为2
        ArrayList<Integer> roadLeft=(ArrayList<Integer>)road.clone();
        roadLeft.add(1);
        aux_countPairs(root.left,roadLeft,result);
        ArrayList<Integer> roadRight=(ArrayList<Integer>)road.clone();
        roadRight.add(-1);
        aux_countPairs(root.right,roadRight,result);

    }
    public int isLeaf(TreeNode x){
        if (x==null){
            return 0;
        }
        if (x.left==null&&x.right==null){
            return 1;
        }
        return 0;
    }
//    public ArrayList<ArrayList<Integer>> aux_countPairs(_1530.TreeNode root, int distance) {
//        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//
//
//    }
}
