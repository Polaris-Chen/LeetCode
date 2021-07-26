package 剑指offer;

/*
* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
public class offer_04_二维数组中的查找_important {

//更好的思路,从右上角开始,比当前节点大就往下,比当前节点小就往左,时间复杂度O(m+n)
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int n=matrix.length;
        if (n==0){
            return false;
        }
        int m=matrix[0].length;
        if (m==0){
            return false;
        }
        int i=0;
        int j=m-1;
        while (-1<i&&i<n&&-1<j&&j<m){

            if (matrix[i][j]==target){
                return true;
            }
            else if (matrix[i][j]>target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    //个人方法,对每行进行二分查找,时间很慢
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int n=matrix.length;
        if (n==0){
            return false;
        }
        int m=matrix[0].length;
        for (int i=0;i<n;i++){
            if (target<matrix[i][0]||target>matrix[i][m-1]){
                continue;
            }
             if (biFind(matrix[i],target,0,m-1)){
                 return true;
             }

        }
        return false;
    }

    public static Boolean biFind(int[] nums,int t,int l,int r){
        if (l>r){
            return false;
        }

        int mid=(l+r)/2;
        if (nums[mid]==t){
            return true;
        }
        else if (nums[mid]<t){
            return biFind(nums,t,mid+1,r);
        }
        else {
           return biFind(nums,t,l,mid-1);
        }

    }
}
