package com.coding.linkedlist;

public class DoublyLinkedList {
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    DoublyLinkedList() {

    }

    public int size() { return this.length; }
    public Node getHead() { return this.head; }
    public Node getTail() { return this.tail; }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if( length == 0 ) {
            this.head = newNode;
            this.tail = newNode;
            length++;
        } else {
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            length--;
            return tmp;
        }
        Node tmp = tail;
        Node prev = tail.prev;
        prev.next = null;
        tmp.prev = null;
        tail = prev;
        length--;
        return tmp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        Node tmp = head;
        head = newNode;
        head.next = tmp;
        tmp.prev = head;
        length++;
        return;
    }

    public Node removeFirst() {
        if(length == 0)
            return null;
        if(length == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            length--;
            return tmp;
        }
        Node tmp = head;
        Node newHead = head.next;
        head = newHead;
        tmp.next = null;
        length--;
        return tmp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length)
            return null;
        if(index < length/2) {
            Node tmp = head;
            for(int i=0; i<index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node tmp = tail;
            for(int i=length-1; i>index; i--) {
                tmp = tmp.prev;
            }
            return tmp;
        }
    }

    public boolean set(int index, int value) {
        Node target = get(index);

        if(target != null) {
            target.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);

        myDLL.printAll();
    }
}
