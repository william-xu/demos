package org.xwl.demo.leetcode;

/**
 * 
 * @author xwl
 *
 *
 *Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 *
 *给定一个二叉树，检查是否自我对称
 *
 */
public class SymmetricTree {

    
    //官方方案，不过递归深内存使用相对多些，但速度快
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }    
    
//    Runtime: 6 ms, faster than 66.81% of Java online submissions for Symmetric Tree.
//    Memory Usage: 38 MB, less than 67.32% of Java online submissions for Symmetric Tree.
    public static boolean isSymmetric_v1(TreeNode root) {
        if(root == null) return true;
        return readTree(root.left,false).equals(readTree(root.right,true));
    }
    
    
    public static String readTree(TreeNode node, boolean reversal) {
        if (node == null) return "-";
        String left = "", right = "";
        if (reversal) {
            right = node.left == null ? "-" : node.left.val + readTree(node.left, reversal);
            left = node.right == null ? "-" : node.right.val + readTree(node.right, reversal);
        } else {
            left = node.left == null ? "-" : node.left.val + readTree(node.left, reversal);
            right = node.right == null ? "-" : node.right.val + readTree(node.right, reversal);
        }
        return node.val + left + right;
    }
    
}
