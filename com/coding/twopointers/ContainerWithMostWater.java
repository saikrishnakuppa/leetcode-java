package com.coding.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int leftIndex = 0;
        int rightIndex = height.length-1;
        while(leftIndex < rightIndex) {
            int w = rightIndex - leftIndex;
            int h = Math.min(height[leftIndex], height[rightIndex]);
            int currentArea = w * h;
            area = Math.max(currentArea, area);
            if(height[leftIndex] < height[rightIndex]) 
                leftIndex++;
            else 
                rightIndex--;
        }
        return area;   
    }
    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        int[] height = {1,2,4,3};
        System.out.println(sol.maxArea(height));
    }
}
