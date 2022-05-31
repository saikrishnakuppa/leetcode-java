package com.coding.trees;

public class BalancedTree {
    private static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) <= 1 &&
                isBalanced(root.right) && isBalanced(root.left);
    }
}
