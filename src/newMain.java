import java.util.*;
import java.util.stream.Stream;

/**
 * @author polarisChen
 * @create 2021/7/21 8:08 下午
 */
public class newMain {
    static  Map<Integer, List<int[]>> map=new HashMap<>();
    static int max=0;
    static Set<Integer> visited;
    static int total=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if (s==null||s.length()==0){
            System.out.println(0);
        }
        String[] arr=s.split("\\[");
        List<int[]> list=new ArrayList<>();
        for (String temp:arr){
            if (temp.length()==0){
                continue;
            }
            temp=temp.replace("]","");
            String[] sArr=temp.split(",");
            int[] tempArr=new int[3];
            int index=0;
            for (String t:sArr){
                tempArr[index++]=Integer.valueOf(t);
            }
            list.add(tempArr);
        }
        if (list.size()==0){
            System.out.println(0);
        }
        Set<Integer> set=new HashSet<>();
        Set<Integer> startSet=new HashSet<>();
        for (int[] temp:list){
            int start=temp[0];
            int end=temp[1];
            startSet.add(start);
            set.add(start);
            set.add(end);
            int distance=temp[2];
            int[] arrInMap=new int[2];
            arrInMap[0]=end;
            arrInMap[1]=distance;
            if (map.containsKey(start)){
                map.get(start).add(arrInMap);
            }else{
                List<int[]> tempList=new ArrayList<>();
                tempList.add(arrInMap);
                map.put(start,tempList);
            }
        }
        int[] starts=new int[startSet.size()];
        int index=0;
        for (int start:startSet){
            starts[index++]=start;
        }
        total=set.size();
        visited=new HashSet<>();
        for (int i=0;i<starts.length;++i){
            dfs(starts[i],0);
        }
        System.out.println(max);
    }

    public static void dfs(int start,int distance){

        if (visited.contains(start)){
            return;
        }
        visited.add(start);

        if (visited.size()==total){
            max=Math.max(max,distance);
            return;
        }
        if (!map.containsKey(start)){
            return;
        }
        List<int[]> nextList=map.get(start);
        for (int[] arr:nextList){
            int end=arr[0];
            int dis= arr[1];
            dfs(end,distance+dis);
        }
        visited.remove(start);
    }
}
