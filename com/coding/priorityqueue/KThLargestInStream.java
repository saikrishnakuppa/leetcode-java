package com.coding.priorityqueue;

import java.util.PriorityQueue;

public class KThLargestInStream {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KThLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>((a , b) -> a - b);
        for(int num: nums) {
            minHeap.add(num);
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KThLargestInStream sol = new KThLargestInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(sol.add(3));
        System.out.println(sol.add(5));
    }
}
