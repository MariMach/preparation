package maths;

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        long n=s.nextLong();
        long dp[]= new long[50000];
        dp[0]=1;
        dp[1]=2;
        int i=1;
        while(dp[i]<=n){
            i++;
            dp[i]=dp[i-1]+dp[i-2];
        }
 
        System.out.println(i-1);
        
    }
}