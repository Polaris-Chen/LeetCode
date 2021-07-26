import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] nums=new int[N][4];
        for (int i = 0; i <N ; i++) {
            String[] x=scanner.nextLine().split(" ");
            nums[i][0]=Integer.parseInt(x[0]);
            nums[i][1]=Integer.parseInt(x[1]);
            nums[i][2]=Integer.parseInt(x[2]);
            nums[i][3]=Integer.parseInt(x[3]);
        }
        int[][] dp=new int[N+1][121];
        for (int i = 1; i <=N ; i++) {
            for (int j = 120; j>=0 ; j--) {
                int do1=j+nums[i-1][0]>120?0:dp[i-1][j+nums[i-1][0]]+nums[i-1][1];
                int do2=j+nums[i-1][2]>120?0:dp[i-1][j+nums[i-1][2]]+nums[i-1][3];
                dp[i][j]=Math.max(Math.max(dp[i-1][j],do1),do2);
                //System.out.println(dp[i][j]);
            }
        }
        HashMap
        System.out.println(dp[N][0]);
    }
}
