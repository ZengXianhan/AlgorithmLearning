package com.company.zengxh.FibonacciSequence;

import java.util.Vector;

public class FibonacciSequence {
    public static int ViolentRecursion(int N) {
        if(N==1 || N==2) { return 1; }
        return ViolentRecursion(N-1) + ViolentRecursion(N-2);
    }

    public static int MemoRecursion(int N){
        if(N<0){return 0;}
        Vector<Integer> memo = new Vector<>(N+1, 0);
        return memoHelper(memo,N);
    }

    static int memoHelper(Vector<Integer> memo, int n){
        if(n==1 || n==2) { return 1; }
        if(memo.get(n) != 0){return memo.get(n);}
        memo.set(n,memoHelper(memo, n-1) + memoHelper(memo,n-2));
        return memo.get(n);
    }

    public static int dpTableBasic(int N){
        if(N < 0) {return 0;}
        if(N == 1) {return 1;}
        Vector<Integer> dp = new Vector<>(N+1, 0);
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for(int i=3; i<= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static int dpTableOptimized(int N){
        if(N < 0) {return 0;}
        if(N == 1) {return 1;}
        int dpPre = 1;
        int dpCurr = 1;
        for(int i=3; i<= N; i++){
            int dpNext = dpCurr + dpPre;
            dpCurr = dpPre;
            dpNext = dpCurr;
        }
        return dpCurr;
    }
}