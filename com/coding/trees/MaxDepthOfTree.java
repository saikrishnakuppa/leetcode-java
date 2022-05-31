package com.coding.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return  1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                TreeNode node = queue.pop();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return level;
    }

    public int maxDepthDFS(TreeNode root) {
        //if(root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.add(root);
        int res = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null) {
                res = Math.max(res, node.depth);
                if(node.left != null) {
                    node.left.depth = node.depth + 1;
                    stack.add(node.left);
                }
                if(node.right != null) {
                    node.right.depth = node.depth + 1;
                    stack.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxDepthOfTree sol = new MaxDepthOfTree();
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode(2, new TreeNode(1, null, null), null);
        root.right = new TreeNode(4, 
                                new TreeNode(3, 
                                            new TreeNode(5, null, null), 
                                            new TreeNode(1, null, null)), 
                                new TreeNode(-1, 
                                            null,
                                            new TreeNode(6, 
                                                        null , 
                                                        new TreeNode(8, 
                                                                    null, 
                                                                    null)
                                                        )
                                            )
                                );
        System.out.println(sol.maxDepthDFS(root));
    }
}
