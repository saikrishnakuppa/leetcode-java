package com.coding.stack;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] current = stack.pop();
                int index = current[0];
                int height = current[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int index = current[0];
            int height = current[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
