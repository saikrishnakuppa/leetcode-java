package com.coding.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int depth;
    
    public TreeNode() {}
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;        
    }
}
