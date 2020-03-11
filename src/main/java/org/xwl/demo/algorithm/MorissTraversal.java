package org.xwl.demo.algorithm;

/**
 * 这个遍历算法的关键点：
 * 1）使用左子树最右侧节点的右孩子保存当前节点
 * 2）前序遍历：在使用最右侧节点右孩子保存当前节点的同时也打印出来，当节点左孩子为空时也进行打印（注意和按序的不同，按序不管当前节点左子树是否为空都打印，前序只有为空时才打印）
 * 3）按序遍历：遍历到最左节点后，节点的左孩子为空，打印当前节点，接着遍历右子树，当遍历完后指针会指向父节点，父节点左子树不为空，遍历完右子树后，同样打印当前节点
 * 4）后序遍历：左孩子为空不打印，遍历完右孩子回到父节点后反转打印左子树最右侧边，遍历完后还需反转打印原根节点处的最右侧边
 * @author xwl
 *
 */
public class MorissTraversal {
	
	/**
	 * 前序遍历(中-左-右)
	 * 一开始就需要打印
	 * @param root
	 */
	public static void pre(TreeNode root) {
		if(root == null) return;
		TreeNode n1 = root, n2;
		while(n1 != null) {
			n2 = n1.getLeft();
			if(n2 != null) {
				while(n2.getRight() != null && n2.getRight() != n1) {
					n2 = n2.getRight();
				}
				if(n2.getRight() == null) {
					n2.setRight(n1);
					System.out.print(n1.getValue() + " ");  //当前节点左子树不为空时，使用左子树最右侧节点的右孩子保存当前节点，并且打印
					n1 = n1.getLeft();
					continue;
				}else {
					n2.setRight(null);
				}
			}else {
				System.out.print(n1.getValue() + " ");		//当前节点左节点为空时，打印当前节点
			}
			n1 = n1.getRight();
		}
		System.out.println();
	}

	/**
	 * 按序遍历（中序: 左-中-右）
	 * 需要先遍历到最左节点才开始打印
	 * @param root
	 */
	public static void in(TreeNode root) {
		if(root == null) return;
		TreeNode n1 = root, n2;
		while(n1 != null) {
			n2 = n1.getLeft();
			if(n2 != null) {
				while(n2.getRight() != null && n2.getRight() != n1) {
					n2 = n2.getRight();
				}
				if(n2.getRight() == null) {
					n2.setRight(n1);
					n1 = n1.getLeft();
					continue;
				}else {
					n2.setRight(null);
				}
			}
			System.out.print(n1.getValue() + " ");
			n1 = n1.getRight();
		}
		System.out.println();
	}
	
	/**
	 * 后序遍历（左-右-中）
	 * 遍历到最左节点才开始打印
	 * @param root
	 */
	public static void post(TreeNode root) {
		if(root == null) return;
		TreeNode n1 = root, n2;
		while(n1 != null) {
			n2 = n1.getLeft();
			if(n2 != null) {
				while(n2.getRight() != null && n2.getRight() != n1) {
					n2 = n2.getRight();
				}
				if(n2.getRight() == null) {
					n2.setRight(n1);
					n1 = n1.getLeft();
					continue;
				}else {
					n2.setRight(null);
					printEdge(n1.getLeft());
				}
			}
			n1 = n1.getRight();
		}
		printEdge(root);
		System.out.println();
	}
	
	protected static void printEdge(TreeNode eRoot) {
		TreeNode r = reverseEdge(eRoot), tmp = r;
		while(tmp != null) {
			System.out.print(tmp.getValue() + " ");
			tmp = tmp.getRight();
		}
		reverseEdge(r);
	}
	
	//从根节点开始反转最右侧节点
	protected static TreeNode reverseEdge(TreeNode eRoot) {
		TreeNode pre = null, right = null;
		while(eRoot != null) {
			right = eRoot.getRight();   //保存右孩子
			eRoot.setRight(pre);		//当前节点右指针指向上一节点
			pre = eRoot;				//上一节点指针指向当前节点
			eRoot = right;				//当前节点指针指向原本的右孩子
		}
		return pre;
	}
	
	
	
}
