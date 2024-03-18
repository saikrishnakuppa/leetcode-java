package com.coding.heap;

import java.util.List;
import java.util.ArrayList;

public class Heap {
    private List<Integer> heap;

    Heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() { return new ArrayList<>(heap); }

    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }
    private int parent(int index) { return (index-1)/2; }
    private void swap(int index1, int index2) {
        int tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() -1;

        while(current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if(heap.size() == 0)
            return null;
        if(heap.size() == 1)
            return heap.remove(0);
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        sinkdown(0);
        return maxValue;
    }

    private void sinkdown(int index) {
        int maxIndex = index;
        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex))
                maxIndex = leftIndex;
            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex))
                maxIndex = rightIndex;
            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(95);
        h.insert(75);
        h.insert(80);
        h.insert(55);
        h.insert(60);
        h.insert(50);
        h.insert(65);
        System.out.println(h.getHeap());
        System.out.println("Removed: " + h.remove());
        System.out.println(h.getHeap());
        System.out.println("removed: " + h.remove());
        System.out.println(h.getHeap());
    }
}
