package org.xwl.demos.leetcode;

import org.xwl.demo.leetcode.BinaryTreeLevelOrderTraversal;
import org.xwl.demo.leetcode.TreeNode;

import junit.framework.TestCase;

public class BinaryTreeLevelOrderTraversalTest extends TestCase{
    
    public void testTry() {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(9);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(12);
        n.right.left = new TreeNode(5);
        n.right.right = new TreeNode(22);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder_v1(n));
    }

    
    public void testTry1() {
        TreeNode n = new TreeNode(1);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder_v1(n));
    }
    
    //[3,9,20,null,null,15,7]
    public void testTry2() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrder(n));
    }
    
    
}
