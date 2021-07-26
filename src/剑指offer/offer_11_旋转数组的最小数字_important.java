package 剑指offer;
/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
* 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  */
public class offer_11_旋转数组的最小数字_important {
    class Solution {
        //纯遍历
        public int minArray(int[] numbers) {
            for(int i=0;i<numbers.length-1;i++){
                if(numbers[i]<=numbers[i+1]){
                    continue;
                }
                else{
                    return numbers[i+1];
                }
            }
            return numbers[0];
        }
//优化方案  用二分思想去解决,如果mid值小于end值,那就证明最小值肯定在mid左边,如果mid值
// 大于end值那就证明最小值肯定在mid右边,如果等于就无法分辨到底在哪边,
// 就暴力遍历,整体时间复杂度会比纯暴力遍历快一些
        public int minArray1(int[] numbers) {
           int start=0;
           int end=numbers.length-1;
           while (start!=end){
               int mid=start+(end-start)/2;//不要直接相加除以2,可能会超过int的最大值
               if (numbers[mid]<numbers[end]){
                   end=mid;
               }
               else if (numbers[mid]>numbers[end]){
                   start=mid+1;
               }
               else {
                  return findMin(numbers,start,end);
               }
           }
           return numbers[start];
        }

        public int findMin(int[] a,int start,int end){
            int min=start;
            for (int i = start+1; i <=end ; i++) {
                if (a[i]<min){
                    min=a[i];
                }
            }
            return min;
        }
    }

}
