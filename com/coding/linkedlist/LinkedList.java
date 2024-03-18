package com.coding.linkedlist;

import java.util.HashSet;

public class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    LinkedList() {

    }
    
    LinkedList(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.length = 1;
        }
    }

    public Node getHead() { return this.head; }
    public Node getTail() { return this.tail; }
    public int size() { return this.length; }
    
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
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if(length == 0) return null;

        Node tmp = head;
        Node newTail = tmp;
        while(tmp.next != null) {
            newTail = tmp;
            tmp = tmp.next;
        }
        newTail.next = null;
        tail = newTail;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return tmp;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        if(length == 1) {
            head = null;
            tail = null;
            length--;
            return head;
        }
        Node tmp = head;
        Node newHead = head.next;
        tmp.next = null;
        head = newHead;
        length--;
        return tmp;
    }

    public Node findMiddlNode() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        if(head == null) return false;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int index) {
	    if(head == null) return null;
	    Node first = head;
	    Node second = head;
	    for(int i=0; i < index; i++) {
	        if(second == null) return null;
	        second = second.next;
	    }
	    while(second != null) {
	        first = first.next;
	        second = second.next;
	    }
	    return first;
	}

    public void reverse() {
        if(length == 0 || length == 1) return;

        Node before = null;
        Node tmp = head;
        Node after = tmp.next;

        while(tmp.next != null) {
            after = tmp.next;
            tmp.next = before;
            before = tmp;
            tmp = after;
        }

        head = tmp;
        head.next = before;
    }

    public void partitionList(int x) {
        if(head == null || head.next == null) return;
        
        Node first = head;
        Node second = head.next;
            
        // swap first and second if second < x and first >= x
        if(second.value < x && first.value >= x) {
            first.next = second.next;
            second.next = first;
            head = second;
        }
        
        first = head;
        second = head.next;
        Node tmp = second.next;
        
        while(tmp != null) {
            if(tmp.value >= x) {
                // do nothing
            } else {
                
                if(second.value < x) {
                    first = second;
                    second = tmp;
                } else {
                    // append the node to first and update first to new node
                    Node target = new Node(tmp.value);
                    
                    first.next = target;
                    target.next = second;
                    first = target;
                    second = second.next;
                }
            }
            tmp = tmp.next;
        }
    }

    public void removeDuplicates() {
        HashSet<Integer> hs = new HashSet<>();
 
        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.value;
 
            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        // myLinkedList.append(5);

        myLinkedList.printAll();

        int k = 1;
        System.out.println(k + "th node from last = " + myLinkedList.findKthFromEnd(k).value);
    }
}
