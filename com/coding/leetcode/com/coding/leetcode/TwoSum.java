package com.coding.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
    /**
     * brute force
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int[] twoSumBF(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,3};
        TwoSum sol = new TwoSum();
        System.out.println(Arrays.toString(sol.twoSum(nums, 4)));
        System.out.println(Arrays.toString(sol.twoSumBF(nums, 4)));
    }
}
