package com.company.zengxh.FibonacciSequence;

import java.util.Vector;

/**
 * @author xianhan.zeng
 */
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
        dp.set(0,0);
        dp.set(1,1);
        dp.set(2,1);
        for(int i=3; i<= N; i++){
            dp.set(i,dp.get(i-1) + dp.get(i-2));
        }
        return dp.get(N);
    }

    public static int dpTableOptimized(int N){
        if(N < 0) {return 0;}
        if(N == 1) {return 1;}
        int dpPre = 1;
        int dpCurr = 1;
        for(int i=3; i<= N; i++){
            int dpNext = dpCurr + dpPre;
            dpPre = dpCurr;
            dpCurr = dpNext;
        }
        return dpCurr;
    }
}