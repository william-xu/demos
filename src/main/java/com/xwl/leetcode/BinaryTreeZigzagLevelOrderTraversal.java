package com.xwl.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        levelOrder(root, 0, result, true);
        levelOrder(root, 0, result, false);
        return result;
    }

    public static void levelOrder(TreeNode node, int lvl, List<List<Integer>> result, boolean leftOrder) {
        if (node == null) return;
        List<Integer> tmp;
        if (result.size() <= lvl) {
            tmp = new LinkedList<Integer>();
            result.add(tmp);
        } else tmp = result.get(lvl);
        if(leftOrder && lvl%2==0) {
            tmp.add(node.val);    
        }else if(!leftOrder && lvl%2!=0) {
            tmp.add(node.val);
        }        
        if(leftOrder) {
            if (node.left != null)  levelOrder(node.left, lvl + 1, result, leftOrder);
            if (node.right != null)  levelOrder(node.right, lvl + 1, result, leftOrder);            
        }else {
            if (node.right != null)  levelOrder(node.right, lvl + 1, result, leftOrder);
            if (node.left != null)  levelOrder(node.left, lvl + 1, result, leftOrder);            
        }
    }
}
