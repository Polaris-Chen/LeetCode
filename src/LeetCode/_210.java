package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author polarisChen
 * @create 2021/7/6 12:55 上午
 */
public class _210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        List<List<Integer>> g=new ArrayList<>();
        for (int i = 0; i <numCourses ; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> s=new Stack<>();
        int[] visited=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {

            if (!dfs(s,visited,i,g)){
                return new int[0];
            }

        }
        for (int i = 0; i < numCourses; i++) {
            result[i]=s.pop();
        }
        return result;
    }
    public boolean dfs(Stack s,int[] visited,int i, List<List<Integer>> g){
        if (visited[i]==1){
            return false;
        }
        if (visited[i]==-1){
            return true;
        }
        visited[i]=1;

        for (Integer j:g.get(i)) {
            if (!dfs(s,visited,j,g)){
                return false;
            }
        }
        visited[i]=-1;
        s.push(i);
        return true;
    }

}
