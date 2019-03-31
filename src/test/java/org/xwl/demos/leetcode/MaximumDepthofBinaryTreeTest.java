package org.xwl.demos.leetcode;

import com.xwl.leetcode.BinaryTreeLevelOrderTraversal;
import com.xwl.leetcode.MaximumDepthofBinaryTree;
import com.xwl.leetcode.TreeNode;

import junit.framework.TestCase;

public class MaximumDepthofBinaryTreeTest extends TestCase{
    
    public void testTry() {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(9);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(12);
        n.right.left = new TreeNode(5);
        n.right.right = new TreeNode(22);
        
        assertTrue(MaximumDepthofBinaryTree.maxDepth(n)==3);
    }

    
    public void testTry1() {
        TreeNode n = new TreeNode(1);
        assertTrue(MaximumDepthofBinaryTree.maxDepth(n)==1);
    }
    
    //[3,9,20,null,null,15,7]
    public void testTry2() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        n.right.right.left = new TreeNode(8);
        n.right.right.left.right = new TreeNode(8);
        n.right.right.left.right.left = new TreeNode(8);
        assertTrue(MaximumDepthofBinaryTree.maxDepth(n)==6);
    }
}
