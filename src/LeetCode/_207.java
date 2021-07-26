package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polarisChen
 * @create 2021/7/6 12:16 上午
 *
 * 和210是同款  都是拓扑,找环路
 * 首先先用list存边,然后对于所有节点进行深搜,判断是否存在环路
 */


public class _207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g=new ArrayList<>();
        //初始化
        for (int i = 0; i < numCourses ; i++) {
            g.add(new ArrayList<>());
        }
        //将边关系导入list
        for (int i = 0; i < prerequisites.length ; i++) {
           g.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //以所有节点为起点进行深搜
        for (int i = 0; i <numCourses ; i++) {
            int[] visited=new int[numCourses];
            //如果有环路
            if (!dfs(visited,g,i)){
                return false;
            }
        }
        return true;
    }
    //深搜,判断是否有环路  visited的 1为正在判断中,-1为已经判断过了
    public boolean dfs(int[] visited,List<List<Integer>> g,int i){
        //如果是1证明找到了自己,有环路
        if (visited[i]==1){
            return false;
        }
        //如果是-1证明已经找过了,没环路,直接返回true
        if (visited[i]==-1){
            return true;
        }
        visited[i]=1;
        //对i的所有邻居深搜
        for (Integer j:g.get(i)) {
            if (!dfs(visited,g,j)){
                return false;
            }
        }
        //深搜结束,证明i为起点没有环路
        visited[i]=-1;
        return true;
    }
}
