package org.xwl.demos.leetcode;

import com.xwl.leetcode.TwoSum;

import junit.framework.TestCase;

public class TwoSumTest extends TestCase{
	
	public void testTwoSum1() {
		int[] a = new int[] {0,0,5};
		int[] result = TwoSum.twoSum_v2(a, 0);
		p(result);
	}

	public void testTwoSum2() {
		int[] a = new int[] {10,0,5};
		int[] result = TwoSum.twoSum_v2(a, 15);
		p(result);
	}
	
	public void testTwoSum3() {
		int[] a = new int[] {2,7,11,15};
		int[] result = TwoSum.twoSum_v2(a, 9);
		p(result);
	}
	
	public void testTwoSum4() {
		int[] a = new int[] {3,2,4};
		int[] result = TwoSum.twoSum_v2(a, 6);
		p(result);
	}

	public void testTwoSum5() {
		int[] a = new int[] {3,3};
		int[] result = TwoSum.twoSum_v2(a, 6);
		p(result);
	}


	public void testTwoSum6() {
		int[] a = new int[] {5,75,25};
		int[] result = TwoSum.twoSum_v2(a, 100);
		p(result);
	}

	public void testTwoSum7() {
		int[] a = new int[] {-3,1, -1,4,5};
		int[] result = TwoSum.twoSum_v2(a, 0);
		p(result);
	}
	
	
	
	private static void p(int[] arr) {
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+",");
		}
		System.out.println(sb.length()>0 ? sb.toString().substring(0,sb.length()-1):"");
	}
	
	
}
