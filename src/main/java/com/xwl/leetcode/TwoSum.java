package com.xwl.leetcode;

import java.util.Arrays;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice. Example:
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 =
 * 9, return [0, 1].
 * 
 * 给定一个整数数组，返回两个相加和等于指定值的数的索引。
 * 可以假定每次输入的数据有且仅有一个匹配返回。数组每个数字不能重复使用。
 * 
 * @author xwl
 *
 */
public class TwoSum {
	
	/**
	 * 官网方案
	 * 注意到如果没有匹配有抛出异常处理
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}	
	
	/**
	 * 第一个方法
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum_v1(int[] nums, int target) {
		int[] r = null;
		int tmp;
		for (int i = 0; i < nums.length; i++) { //对数组循环遍历
			tmp = target - nums[i];				 //对当前元素计算和目标值的差值
			for (int j = i + 1; j < nums.length; j++) {  //将差值与剩元素遍历比较，如果匹配则返回两数索引 i,j
				if (nums[j] == tmp) {
					return new int[] { i, j };
				}
			}
		}
		return r;
	}
	
	/**
    这个方案要快得多，但是占用内存也多
    相对也复杂了，没第一个简单明了
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum_v2(int[] nums, int target) {
		int[] r = null;
		// 先复制排序
		int[] a = nums.clone();
		Arrays.sort(a);
		//开始和结尾索引
		int start = 0, end = a.length - 1;
		while (start < end) {
			if ((a[start] + a[end]) > target) { // 首尾相加如果大于目标值，则后面的索引往前移
				end--;
			} else if ((a[start] + a[end]) < target) { //相加小于目标值，则前面的索引往前移
				start++;
			} else { // 两数相加等于目标值，由于排序了，需要再遍历一次原始数组定位两个数的位置并返回
				int[] tmp = new int[] { -1, -1 };  //临时数组保存两个索引
				for (int i = 0; i < nums.length; i++) {
					if (nums[i] == a[start] && tmp[0] == -1) { //第一个数
						tmp[0] = i;
					} else if (nums[i] == a[end] && tmp[1] == -1) {//第二个数
						tmp[1] = i;
					}
					if (tmp[0] >= 0 && tmp[1] >= 0) { //对索引数组排序后再返回
						Arrays.sort(tmp);
						return tmp;
					}
				}
			}
		}
		return r;
	}

}
