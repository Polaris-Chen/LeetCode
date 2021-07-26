package 剑指offer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author polarisChen
 * @create 2021/2/18 1:30 下午
 */
public class offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else {
                if (arr[i] < heap.peek()) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }
        int[] x = new int[k];
        for (int i = 0; i < k; i++) {
            x[i] = heap.poll();
        }

        return x;


    }
    public void  quicksort(int[] arr) {

    }

    public void  aux_quicksort(int[] arr,int l,int r) {
        int flag=arr[l];
        int left=l+1;
        int right=r;
        while (left<right) {
            while (left<r&&arr[left] < flag) {
                left++;
            }
            while (right>l&&arr[right]>flag){
                right--;
            }
            swap(arr,left,right);
        }
    }

    public void swap(int[] x,int a,int b){
        int temp=x[a];
        x[a]=x[b];
        x[b]=temp;
    }

}
