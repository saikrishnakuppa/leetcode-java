package com.coding.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Deque<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.pop();
                l.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), 
        new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        System.out.println(levelOrder(root));
    }
}
