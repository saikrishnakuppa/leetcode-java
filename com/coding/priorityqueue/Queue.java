package com.coding.priorityqueue;

public class Queue {
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
        Node(){}
    }

    int length;
    Node first;
    Node last;

    Queue(int value) { first = new Node(value); last = first; length++; }

    public void print() {
        Node tmp = first;
        while(tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public Node dequeue() {
        Node tmp = first;
        if(first == null && last == null) return null;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            tmp.next = null;
        }
        length--;
        return tmp;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(first == null && last == null) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public static void main(String[] args) {
        Queue q = new Queue(7);
        q.enqueue(3);
        q.enqueue(9);
        q.print();
        System.out.println("Result: " + q.dequeue().value);
    }
}
