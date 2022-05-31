package com.coding.trees;

public class SubTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubTree(TreeNode p, TreeNode q) {
        if(q == null)
            return true;
        if(p == null)
            return false;
        
        if(isSameTree(p, q))
            return true;
        return (isSubTree(p.right, q) || isSubTree(p.left, q));
    }
}
