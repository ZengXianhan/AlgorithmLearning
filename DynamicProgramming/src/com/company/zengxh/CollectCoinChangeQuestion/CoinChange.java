package com.company.zengxh.CollectCoinChangeQuestion;

/**
 * @author xianhan.zeng
 */
public class CoinChange {
    public static int ViolentRecursion(int[] coins, int amount) {
        if(amount < 0){
            return -1;
        }
        else if(amount == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin :
                coins) {
            int subProblem = ViolentRecursion(coins, amount - coin);
            if(subProblem == -1){ continue;}
            res = Math.min(res, subProblem + 1);
        }

        if(res == Integer.MAX_VALUE){ res = -1;}
        return res;
    }
}
