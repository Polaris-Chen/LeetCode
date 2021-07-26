package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _1443 {
    int sum=0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int flag=n/2;
        while (flag>=0) {
            flag--;
            for (int i = 0; i < n - 1; i++) {
                if (hasApple.get(edges[i][1])) {
                    hasApple.set(edges[i][0], true);

                } else if (hasApple.get(edges[i][0])) {
                    hasApple.set(edges[i][1], true);
                }
            }
        }

        for (int j = 0; j <hasApple.size(); j++) {
            if (hasApple.get(j)){
                sum+=2;
            }
        }
        return sum-2;
    }
}
