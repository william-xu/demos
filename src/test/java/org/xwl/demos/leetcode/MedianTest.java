package org.xwl.demos.leetcode;

import com.xwl.leetcode.Median;

import junit.framework.TestCase;

public class MedianTest extends TestCase{

	public void testM1() {
		int[] nums1 = {1,3};
		int[] nums2 = {2};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}
	
	public void testM2() {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}

	
	public void testM3() {
		
		int[] nums1 = {3, 5,7, 11, 13,22,26};
		int[] nums2 = {9,12,16,18, 20,25,38,55,78};
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}
	
	public void testM4() {
		int[] nums1 = {100000};
		int[] nums2 = {100001};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}
	
	public void testM5() {
		int[] nums1 = {};
		int[] nums2 = {1};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}

	public void testM6() {
		int[] nums1 = {3};
		int[] nums2 = {-2,-1};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}
	
	public void testM7() {
		int[] nums1 = {1};
		int[] nums2 = {2,3};		
		System.out.println(Median.findMedianSortedArrays_v1(nums1, nums2));
	}	
	
}
