package org.xwl.demos.leetcode;

import com.xwl.leetcode.SymmetricTree;
import com.xwl.leetcode.TreeNode;

import junit.framework.TestCase;

public class SymmetricTreeTest extends TestCase{
    
    public void testSymmetricTrue1() {
        assertTrue(SymmetricTree.isSymmetric(createTreeNode(0)));        
    }
    
    
    public void testSymmetricFalse1() {
        assertFalse(SymmetricTree.isSymmetric(createTreeNode(1)));
    }
    
    public void testSymmetricFalse2() {
        TreeNode node = createTreeNode(2);
        assertFalse(SymmetricTree.isSymmetric(node));
    }
    
    public void testSymmetricFalse3() {
        TreeNode node = createTreeNode(3);
        System.out.println(SymmetricTree.readTree(node.left, false));
        System.out.println(SymmetricTree.readTree(node.right, true));
        assertFalse(SymmetricTree.isSymmetric(node));
    }
    
    
    public static TreeNode createTreeNode(int id) {
        TreeNode node = new TreeNode(1);
        if(id == 0) {
            node.left = new TreeNode(2);
            node.right = new TreeNode(2);
            node.left.left = new TreeNode(3);
            node.left.right = new TreeNode(4);
            node.right.left = new TreeNode(4);
            node.right.right = new TreeNode(3);        
            node.left.left.left = new TreeNode(5);
            node.left.left.right = new TreeNode(6);
            node.left.right.right = new TreeNode(8);
            node.right.right.left = new TreeNode(6);
            node.right.right.right = new TreeNode(5);
            node.right.left.left = new TreeNode(8);            
        }else if(id == 1){
            node.left = new TreeNode(2);
            node.right = new TreeNode(2);
            node.left.right = new TreeNode(3);
            node.right.right = new TreeNode(3);
        }else if(id == 2){
            node.left = new TreeNode(2);
            node.left.left = new TreeNode(3);
        }else if(id == 3){
            node.left = new TreeNode(2);
            node.right = new TreeNode(3);
        }

        
        
        return node;
    }
    
    
}
