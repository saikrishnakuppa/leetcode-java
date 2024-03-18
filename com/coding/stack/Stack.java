package com.coding.stack;

public class Stack {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node top;
    int height;

    Stack(int value) {
        top = new Node(value);
        height++;
    }

    Stack() {}

    public void print() {
        Node tmp = top;
        while(tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public Node getTop() { return top;}
    public int getHeight() { return height;}

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    public Node pop() {
        if(top == null) return null;
        Node tmp = top;
        top = top.next;
        tmp.next = null;
        height--;
        return tmp;
    }

    public static void main(String[] args) {
        Stack s = new Stack(4);
        s.push(2);
        s.push(1);
        s.print();
        System.out.println("Result: " + s.pop().value);
        s.print();
    }

}
