package 剑指offer;

/*
*输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
* 题目难点在于大数,最好的办法是一位位确定数字,然后删掉左边多余的0
*
* */

public class offer_17_打印从1到最大的n位数_important {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.printNumbers(6));
    }
       static class Solution {
            char[] num=new char[]{'0','1','2','3','4','5','6','7','8','9'};
            StringBuilder res=new StringBuilder();
            char[] chars;

            public String printNumbers(int n) {
                res.append("0");
                chars=new char[n];
                dfs(0);
                res.deleteCharAt(res.length()-1);
                return res.toString();
            }

            public void dfs(int x){
                if (x==chars.length){
                    res.append(deleteZero(String.valueOf(chars))).append(",");
                    return;
                }
                for (int i = 0; i <num.length ; i++) {
                    chars[x]=num[i];
                    dfs(x+1);
                }
            }

            public String deleteZero(String x){
                int i=0;
                while (i<x.length()&&x.charAt(i)=='0'){
                    i++;
                }
                if (i>0){
                    return x.substring(i);
                }
                else {
                    return x;
                }
            }
        }


}
