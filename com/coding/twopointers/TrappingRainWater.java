package com.coding.twopointers;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height == null)
            return 0;
        int res = 0;
        int l=0, r=height.length - 1;
        int leftMax=height[l], rightMax = height[r];
        
        while (l < r) {
            if(leftMax < rightMax) {
                l += 1;
                leftMax = Math.max(leftMax, height[l]);
                res = res + leftMax - height[l];
            } else {
                r -= 1;
                rightMax = Math.max(rightMax, height[r]);
                res  = res + rightMax - height[r];
            }
        }

        return res;
    }
}
