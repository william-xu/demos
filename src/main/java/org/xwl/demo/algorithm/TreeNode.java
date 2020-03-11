package org.xwl.demo.algorithm;

public class TreeNode {
	private int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	private TreeNode left;
	private TreeNode right;

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode setLeft(TreeNode left) {
		this.left = left;
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public TreeNode setRight(TreeNode right) {
		this.right = right;
		return right;
	}

	public int getValue() {
		return value;
	}

	public TreeNode setValue(int value) {
		this.value = value;
		return this;
	}	
	
}
