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
}