package com.xwl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero. Note: The solution set must not contain duplicate triplets.
 *
 * 给定一个整数数组，求是否有三个元素之和等于0。
 * 找出所有满足条件且不重复的三元素数组
 * 
 * @author xwl
 *
 */
public class ThreeSum {
	
	/**
	 * 分析：
	 * 1）三数和等于0，要么全0，要么必须有负数
	 * 2）排序后，前面部分是负数，只需遍历所有小于等于0的元素即可
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		//先排序
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			//先遍历 n-2个元素,如果第一元素比最大正数两倍还大，则索引前移
			while (i<nums.length-2 && (nums[i] + nums[nums.length - 1] * 2 < 0)) i++;//非必要,可移除
			if (nums[i] > 0) break; //如果大于0则终止
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //如果是第一个元素，或者非第一个元素，且当前元素与下个元素不等才执行（即跳过重复元素）				
				//对当前元素值取反，并对剩下区间进行统计有无两数和与之相等
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];				
				while (nums[hi] > 2 * sum) hi--; //从后往前遍历，如果最大正数比取反后的值的两倍还大，则高位索引往低位移动，缩窄区间，也是非必要，可以移除
				while (lo < hi) {				
					if (nums[lo] + nums[hi] == sum) {  //1）高低两数相加匹配取反值，则添加进结果列表
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1]) lo++;  //如果低位紧接的数与已匹配的重复，则索引向高位移
						while (lo < hi && nums[hi] == nums[hi - 1])	 hi--; //如果高位紧接的数与已匹配的重复，则索引向低位移
						lo++; hi--; //剩余未比较区间
					} else if (nums[lo] + nums[hi] < sum) lo++;  //2）如果前后两数相加值小于取反值，则低位索引往高位移
					else hi--; //3）如果两数相加值大于取反值，高位索引往前移								
				}
			}
		}
		return res;
	}

}




