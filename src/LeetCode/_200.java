package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.Element;

import java.util.*;

/**
 * @author polarisChen
 * @create 2021/6/20 9:06 下午
 */
public class _200 {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        List<String> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if (grid[i][j]=='1'){
                    String temp=Integer.toString(i)+"_"+ Integer.toString(j);
                    list.add(temp);
                }
            }
        }
        UnionSet<String> unionSet=new UnionSet<>(list);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]=='1'){
                    String mid=Integer.toString(i)+"_"+ Integer.toString(j);
                    if (i+1<n&&grid[i+1][j]=='1'){
                        String down=Integer.toString(i+1)+"_"+ Integer.toString(j);
                        unionSet.union(down,mid);
                    }

                    if (j+1<m&&grid[i][j+1]=='1'){
                        String right=Integer.toString(i)+"_"+ Integer.toString(j+1);
                        unionSet.union(right,mid);
                    }
                }
            }
        }
        return unionSet.count;
    }

   class UnionSet<T>{
        class Element<T>{
            public T value;
            Element(T value){
                this.value=value;
            }
        }
        public HashMap<T,Element<T>> valueMap;
        public HashMap<Element<T>,Element<T>> fatherMap;
        int count;

        UnionSet(List<T> list){
            valueMap=new HashMap<>();
            fatherMap=new HashMap<>();
            count=0;
            for (T t: list){
                Element e=new Element(t);
                valueMap.put(t, e);
                fatherMap.put(e,e);
                count++;
            }
        }

        public Element<T> findFather(Element<T> e){
            while (fatherMap.get(e)!=e){
                e=fatherMap.get(e);
            }
            return e;
        }
        public void union(T t1,T t2){
            Element<T> head1=findFather(valueMap.get(t1));
            Element<T> head2=findFather(valueMap.get(t2));

            if (head1!=head2){
                fatherMap.put(head2, head1);
                count--;
            }
        }

   }
}
