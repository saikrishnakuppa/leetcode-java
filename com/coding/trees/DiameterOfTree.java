package com.coding.trees;

public class DiameterOfTree {
    private static int treeDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return treeDiameter;
    }

    private static int dfs(TreeNode currentNode) {
        if (currentNode == null)
            return -1;

        int leftTreeHeight = dfs(currentNode.left);
        int rightTreeHeight = dfs(currentNode.right);

        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a leaf node on each side
        if (leftTreeHeight != 0 && rightTreeHeight != 0) {

            // diameter at the current node will be equal to the height of left subtree +
            // the height of right sub-trees + '1' for the current node
            //int diameter = leftTreeHeight + rightTreeHeight + 1;

            // update the global tree diameter
            treeDiameter = Math.max(treeDiameter, 2 + leftTreeHeight + rightTreeHeight);
        }

        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1' for the current node
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
