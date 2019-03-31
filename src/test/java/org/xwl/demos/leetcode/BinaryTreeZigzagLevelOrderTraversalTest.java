package org.xwl.demos.leetcode;

import com.xwl.leetcode.BinaryTreeZigzagLevelOrderTraversal;
import com.xwl.leetcode.TreeNode;

import junit.framework.TestCase;

public class BinaryTreeZigzagLevelOrderTraversalTest extends TestCase{
    
    public void testTry() {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(9);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(12);
        n.right.left = new TreeNode(5);
        n.right.right = new TreeNode(22);
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(n));
    }

    
    public void testTry1() {
        TreeNode n = new TreeNode(1);
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(n));
    }
    
    public void testTry2() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);        
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(n));
    }    
    
    //[1,2,3,4,null,null,5]
    public void testTry3() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.right.right = new TreeNode(5);        
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(n));
    }
 
    //[0,2,4,1,null,3,-1,5,1,null,6,null,8]
    //expected: [[0],[4,2],[1,3,-1],[8,6,1,5]]
    public void testTry4() {
        TreeNode n = new TreeNode(0);
        n.left = new TreeNode(2);
        n.right = new TreeNode(4);
        n.left.left = new TreeNode(1);
        n.right.left = new TreeNode(3);
        n.right.right = new TreeNode(-1);        
        n.left.left.left = new TreeNode(5);
        n.left.left.right = new TreeNode(1);
        n.right.left.right = new TreeNode(6);
        n.right.right.right = new TreeNode(8);
        System.out.println(BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(n));
    }    
    
}
