package org.xwl.demo.leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 * 
 * @author xwl
 *
 */
public class MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        return maxDepth(root,1);
    }
    
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
        Memory Usage: 40.1 MB, less than 5.01% of Java online submissions for Maximum Depth of Binary Tree.
     * @param node
     * @param depth
     * @return
     */
    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth - 1;
        if (node != null && (node.left == null && node.right == null)) return depth;
        int left = maxDepth(node.left, depth + 1);
        int right = maxDepth(node.right, depth + 1);
        return left > right ? left : right;        
    }
    
}
