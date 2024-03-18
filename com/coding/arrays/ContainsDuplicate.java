package com.coding.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(s.contains(nums[i]))
                return true;
            else
                s.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
