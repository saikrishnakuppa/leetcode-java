package com.coding.leetcode;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0, right = 1;
        while(right < prices.length) {
            if(prices[left] < prices[right])
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            else
                left = right;
            right++;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        BestTimeToBuySellStock sol = new BestTimeToBuySellStock();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
