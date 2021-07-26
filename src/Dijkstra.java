
//https://blog.csdn.net/qq_34842671/article/details/90083037
//测试用例
//7 10
//0 1 6
//1 2 5
//0 3 2
//3 1 7
//3 4 5
//1 2 5
//1 5 3
//4 5 5
//5 4 2
//4 6 1
//0


//思路就是先更新和源点相连的节点的路径,如果不相连就是用一个很大的值代替,然后找到其中路径最短的那个节点B,
// visited置为1,表示已经找到了到这个点的最短路径,然后进行更新,shortPath数组代表源点到其他节点的最短距离
// shortPath[i]=min(shortPath[C],shortPath[B]+B->C),C就是任意还没找到最短路径的点
//然后继续循环

import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] ne=scanner.nextLine().split(" ");
        int n=Integer.parseInt(ne[0]);
        int e=Integer.parseInt(ne[1]);
        int[][] graph=new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i!=j){
                    //初始化,全部节点都不相连
                    graph[i][j]=1000000;
                }
            }
        }


        for (int i=0;i<e;i++){
            String[] s=scanner.nextLine().split(" ");

            graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=Integer.parseInt(s[2]);
        }
        find(graph,0);
    }

    public static  void find(int[][] graph,int start){
        int n=graph.length;
        //代表是否已经找到了最短路径
        int[] visited=new int[n];
        //最短路径的值
        int[] shortPath=new int[n];

        //初始化
        shortPath[start]=0;
        visited[start]=1;
        //先把和源点相连的点加入最短路径数组
        for (int i=0;i<n;i++){
            shortPath[i]=graph[start][i];
        }
        //开始循环,只要循环n-1次就行
        for (int i=1;i<n;i++){
            int min=100000;
            int index=-1;


            for (int j=0;j<n;j++){
                //找到当前状态下源点到所有节点中的最小值
                if (visited[j]==0&&shortPath[j]<min){

                    min=shortPath[j];
                    index=j;
                }
            }
            //这个点的最短路径已经找到
            visited[index]=1;


            //更新通过这个点到其他点的最短路径
            for(int k=0;k<n;k++){
                if (visited[k]==0&&shortPath[index]+graph[index][k]<shortPath[k]){
                    shortPath[k]=shortPath[index]+graph[index][k];
                }
            }

        }
        for (int i=0;i<n;i++) {
            System.out.println(shortPath[i]);
        }
    }

}
