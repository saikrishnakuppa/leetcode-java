package com.coding.dynamicprogramming;

/**
 * Your are climbming a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways you can climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int steps) {
        int one = 1, two = 1;

        for(int i=0; i < steps-1; i++) {
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }
    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(3));
    }
}
