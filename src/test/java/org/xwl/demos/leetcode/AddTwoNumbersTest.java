package org.xwl.demos.leetcode;

import com.xwl.leetcode.AddTwoNumbers;
import com.xwl.leetcode.ListNode;

import junit.framework.TestCase;

public class AddTwoNumbersTest extends TestCase{
	
	public void testA1() {		
		int[] a = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		int[] b = {5,6,4};		
		ListNode a1 = genNode(a);
		ListNode a2 = genNode(b);		
		System.out.println(getValue(AddTwoNumbers.addTwoNumbers_v2(a1, a2)));
	}
	
	public void testA2() {
		int[] a = {5};
		int[] b = {5};
		
		ListNode a1 = genNode(a);
		ListNode a2 = genNode(b);
		
		System.out.println(getValue(AddTwoNumbers.addTwoNumbers_v2(a1, a2)));

	}
	
	public void testA3() {		
		int[] a = {1};
		int[] b = {9,9};
		
		a = new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		b = new int[] {5,6,4};
		
		a = new int[] {1,2,3,4,5};
		b = new int[] {7,8,9};		
		
		ListNode a1 = genNode(a);
		ListNode a2 = genNode(b);
		
		System.out.println(getValue(AddTwoNumbers.addTwoNumbers_v2(a1, a2)));

	}

	
	public void testA4() {
		int[] a = {0};
		int[] b = {7,3};
			
		ListNode a1 = genNode(a);
		ListNode a2 = genNode(b);
		
		System.out.println(getValue(AddTwoNumbers.addTwoNumbers_v2(a1, a2)));
	}
		
	
	public static ListNode genNode(int[] a) {
		ListNode ln = null;
		ListNode tmp = null;
		if(a != null && a.length >0) {
			for(int i=a.length-1;i>=0;i--) {
				tmp = new ListNode(a[i]);
				if(ln == null) {
					ln = tmp;
				}else {
					tmp.next = ln;
					ln = tmp;
				}
			}
		}
		
		return ln;
	}
	
	/**
	 * 获取该链表对应值的正常顺序
	 * @param node
	 * @return
	 */
	public static String getValue(ListNode node) {
		if(node.next == null) {
			return String.valueOf(node.val);
		}
		return getValue(node.next) + String.valueOf(node.val);
	}
	
}
