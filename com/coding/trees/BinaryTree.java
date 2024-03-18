package com.coding.trees;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    BinaryTree() {

    }

    public Node getRoot() { return this.root; }

    public boolean contains(int value) {
        Node tmp = root;
        while(tmp != null) {
            if(tmp.value == value) {
                return true;
            }
            if(value < tmp.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return false;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
            return true;
        }

        Node currentNode = root;
        while(true) {
            if(value == currentNode.value) {
                return false;
            }
            if(value < currentNode.value) {
                if(currentNode.left == null) {
                    currentNode = newNode;
                    return true;
                }
                currentNode = currentNode.left;
            } else if(value > currentNode.value) {
                if(currentNode.right == null) {
                    currentNode = newNode;
                    return true;
                }
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * recursion
     */
    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if(currentNode == null) {
            return new Node(value);
        }

        if(value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if(root == null) {
            root = new Node(value);
        }
        rInsert(root, value);
    }

    private Node rDelete(Node currentNode, int value) {
        if(currentNode == null) {
            return null;
        }
        if(value < currentNode.value) {
            currentNode.left = rDelete(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = rDelete(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if(currentNode.left != null && currentNode.right == null) {
                currentNode = currentNode.left;
            } else if(currentNode.left == null && currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = rDelete(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    private int minValue(Node currentNode) {
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void rDelete(int value) {
        if(root == null) return;
        rDelete(root, value);
    }

    /**
     * BFS & DFS
     */
    public List<Integer> bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> results = new ArrayList<>();

        if(root == null) return results;
        queue.add(root);

        while(queue.size() > 0) {
            Node currNode = queue.remove();
            results.add(currNode.value);
            if(currNode.left != null)
                queue.add(currNode.left);
            if(currNode.right != null)
                queue.add(currNode.right);
        }
        return results;
    }

    public List<Integer> dfsPreOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                if(currentNode.right != null)
                    new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public List<Integer> dfsPostOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                if(currentNode.right != null)
                    new Traverse(currentNode.right);
                
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public List<Integer> dfsInOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                
                results.add(currentNode.value);

                if(currentNode.right != null)
                    new Traverse(currentNode.right);
                
            }
        }
        new Traverse(root);
        return results;
    }

    public Integer kthSmallest_No_Recursion(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
 
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }

}
