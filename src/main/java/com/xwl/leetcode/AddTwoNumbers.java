package com.xwl.leetcode;

/**
 * 
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * @author xwl
 *
 */

public class AddTwoNumbers {
	
	/**
	 * Runtime: 21 ms, faster than 68.40% of Java online submissions for Add Two Numbers.
		Memory Usage: 48 MB, less than 33.14% of Java online submissions for Add Two Numbers.
		Next challenges:
		
		官网方案: 相对简洁明了多
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}	
		
	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		else if (l2 == null) return l1;

		ListNode dummyHead = new ListNode(0), curr = dummyHead, tmp;
		int val;
		int carry = 0;	// 等于1时标识节点值相加大于10需要进1
		while (l1 != null) { 		//从链表1开始遍历
			val = l1.val + carry;	//第一节点值以及是否前面有进1
			if (l2 != null) {		//如果链表2节点不为空，则再加上链表2节点值，并且指向链表2节点指向下一个
				val += l2.val;
				l2 = l2.next;
			}
			carry = val / 10;				//是否需要进1
			tmp = new ListNode(val % 10);	//创建相加后的新节点
			curr.next = tmp;				//由于链表是从低位->高位，将当前节点的下个节点指向新节点
			curr = curr.next;				//设置新节点为当前节点
			if (l1.next == null && l2 != null) {  //当链表1遍历完并且链表未遍历完时，设置链表2引用代替链表1引用，并将链表2引用设置为null不再遍历
				l1.next = l2;
				l2 = null;
			}
			l1 = l1.next;	//当前节点计算完，接着计算下个节点
		}
		if (carry > 0) //最后节点计算完还有进1的话
			curr.next = new ListNode(1);

		return dummyHead.next;
	}
	
	/**
        Runtime: 23 ms, faster than 40.70% of Java online submissions for Add Two Numbers.
        Memory Usage: 39.7 MB, less than 93.62% of Java online submissions for Add Two Numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
		if (l1 == null || (l1.val == 0 && l1.next == null)) {
			return l2;
		} else if (l2 == null || (l2.val == 0 && l2.next == null)) {
			return l1;
		}
		StringBuilder sb1 = new StringBuilder(String.valueOf(l1.val));
		StringBuilder sb2 = new StringBuilder(String.valueOf(l2.val));
		ListNode ln = l1;
		while((ln = ln.next) != null) sb1.append(ln.val);
		ln = l2;
		while((ln = ln.next) != null) sb2.append(ln.val);
		String small = sb1.length()>sb2.length() ? sb2.toString():sb1.toString();
		String bigger = sb1.length()>sb2.length() ? sb1.toString():sb2.toString();
		int s_len = small.length();
		int val;
		boolean p = false;
		ListNode root = null, node = null;
		for (int i = 0; i < bigger.length(); i++) {
			val = Integer.parseInt(String.valueOf(bigger.charAt(i)));
			if (p) {
				val++;
				p = false;
			}				
			if (i<s_len) val += Integer.parseInt(String.valueOf(small.charAt(i)));
			if (val >= 10) {
				val = val % 10;
				p = true;
			}
			ln = new ListNode(val);
			if (node == null) {
				node = ln;
				root = ln;
			} else {
				node.next = ln;
				node = ln;
			}
		}
		if(p) {
			ln = new ListNode(1);
			node.next = ln;
		}
		return root;
	}
	
	
}