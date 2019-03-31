package com.xwl.leetcode;

import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author xwl
 *
 */
public class BinaryTreeLevelOrderTraversal {
       
    /**
     * Runtime: 1 ms, faster than 74.84% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
       Memory Usage: 37.2 MB, less than 16.19% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            levelOrder(root, 0, result);
        }
        return result;
    }
    
    public static void levelOrder(TreeNode node, int lvl, List<List<Integer>> result) {
        if (node == null) return;
        List<Integer> tmp;
        if (result.size() <= lvl) {
            tmp = new LinkedList<Integer>();
            result.add(tmp);
        } else tmp = result.get(lvl);
        tmp.add(node.val);
                
        if (node.left != null)  levelOrder(node.left, lvl + 1, result);
        if (node.right != null)  levelOrder(node.right, lvl + 1, result);        
    }
    
    public static List<List<Integer>> levelOrder_v1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            int lvl = 0;
            LinkedList<Integer> r = new LinkedList<>();
            r.add(root.val);
            result.add(r);
            levelOrder_v1(root.left, lvl + 1, result);
            levelOrder_v1(root.right, lvl + 1, result);
        }
        return result;
    }

    public static void levelOrder_v1(TreeNode node, int lvl, List<List<Integer>> result) {
        if (node == null) return;
        List<Integer> tmp;
        if (result.size() <= lvl) {
            tmp = new LinkedList<Integer>();
            result.add(tmp);
        } else tmp = result.get(lvl);
        tmp.add(node.val);
                
        if (node.left != null)  levelOrder_v1(node.left, lvl + 1, result);
        if (node.right != null)  levelOrder_v1(node.right, lvl + 1, result);        
    }
    
}
