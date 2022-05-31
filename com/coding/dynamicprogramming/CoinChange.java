package com.coding.dynamicprogramming;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i=1; i <= amount; i++) {
            dp[i] = amount + 1;
            for(int c : coins) {
                if(i - c >= 0) 
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }
        if(dp[amount] != amount + 1)
            return dp[amount];
        else return -1;
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{1,3,4,5}, 7));
    }
}
