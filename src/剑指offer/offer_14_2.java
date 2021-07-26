package 剑指offer;

import java.math.BigInteger;

public class offer_14_2 {
    static class Solution {
        public int cuttingRope(int n) {
            if (n==2) {
                return 1;
            }
            else if(n==3){
                return 2;
            }
            BigInteger[] d=new BigInteger[1001];
            d[0]=new BigInteger("1");
            d[1]=new BigInteger("1");
            d[2]=new BigInteger("2");
            d[3]=new BigInteger("3");
            for (int i = 4; i < n+1; i++) {
                d[i]=new BigInteger("1");
                for (int j = i; j >i/2-1; j--) {//只要到中间就可以停了,后面都是重复的
                    d[i]=d[i].max(d[i-j].multiply(d[j]));
                }
            }
            BigInteger a=d[n].mod(new BigInteger("1000000007"));
            return a.intValue();
        }
        }

        public static void main(String[] args) {
            offer_14_1.Solution s=new offer_14_1.Solution();
            System.out.println(s.cuttingRope(10));
        }
    }

