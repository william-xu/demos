package org.xwl.demo.leetcode;

/**
 * 	There are two sorted arrays nums1 and nums2 of size m and n respectively.
   	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	You may assume nums1 and nums2 cannot be both empty.
	
	Example 1:
	nums1 = [1, 3]
	nums2 = [2]
	The median is 2.0
	
	Example 2:
	nums1 = [1, 2]
	nums2 = [3, 4]

	The median is (2 + 3)/2 = 2.5
	
	
	中值（又称中位数）是指将统计总体当中的各个变量值按大小顺序排列起来，形成一个数列，处于变量数列中间位置的变量值就称为中位数。
	中值也称中位数，即数据按升序或者降序排列，假如有n个数据，当n为偶数时，中位数为第n/2位数和第(n+2)/2位数的平均数；如果n为奇数，那么中位数为第（n+1）/2位数的值。
	
	
 * @author xwl
 *
 */
public class Median {
	
	//别人的方案
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int all = nums1.length + nums2.length;
		int len1 = nums1.length;
		int len2 = nums2.length;
		int index = 0;

		int i1 = 0, i2 = 0;
		int targetStartIndex = (all / 2) + 1;
		int[] ret = new int[2];

		while (index < targetStartIndex) {
			ret[0] = ret[1];
			if (i1 < len1 && i2 < len2) {
				if (nums1[i1] < nums2[i2]) {
					ret[1] = nums1[i1];
					i1++;
				} else {
					ret[1] = nums2[i2];
					i2++;
				}
			} else if (i1 < len1) {
				ret[1] = nums1[i1];
				i1++;
			} else {
				ret[1] = nums2[i2];
				i2++;
			}
			index++;
		}

		if (all % 2 == 1) {
			return ret[1];
		} else {
			return (ret[0] + ret[1]) / 2.0;
		}
	}
	
	/**
	 * 官方方案
	 * @param A
	 * @param B
	 * @return
	 */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        //定义变量m和n，分别代表较短数组长度和较长数组长度
    	int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n， 保证A是指向短数组，B指向长数组
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        for(int k=0;k<A.length;k++) {
        	System.out.print(A[k]+",");
        }
        System.out.println();
        for(int k=0;k<B.length;k++) {
        	System.out.print(B[k]+",");
        }        
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2; 
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;        
            if (i < iMax && B[j-1] > A[i]){ 
            	System.out.println("B[j-1]=" + B[j-1] + " ,A[i]="+ A[i] + ",i="+i + "太小");
                iMin = i + 1; // i is too small 
            }
            else if (i > iMin && A[i-1] > B[j]) {
            	System.out.println("A[i-1]==" + A[i-1] + ",B[j]==" + B[j]);
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
            	System.out.println("why perfect?" + "i=" + i + ",j=" + j);
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }	
	
	/**
	 * 已知两个已排序数组
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays_v1(int[] nums1, int[] nums2) {
		// 如果两个数组只各有一个元素
		if (nums1.length == 1 && nums2.length == 1) return ((nums1[0] + nums2[0]) / 2d);
		else if (nums1.length == 0) // nums1为空
			return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d : nums2[nums2.length / 2];
		else if (nums2.length == 0) // nums2为空
			return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d : nums1[nums1.length / 2];

		//两数组总长，第一个中值索引
		int total = nums1.length + nums2.length, mIdx = total % 2 == 0 ? total / 2 - 1 : total / 2;
		//使用idx作为两个数组合并的索引，idx1作为第一个，idx2作为第2个
		int idx = 0,idx1 = 0, idx2 = 0;
		double curr = 0;
		while (idx <= mIdx) {   //当小于中值索引时
			if (idx1 >= nums1.length) { //如果数组1已经遍历完
				curr = nums2[idx2];     //则当前元素取数组2的
				idx2++;					//数组2索引加1
			} else if (idx2 >= nums2.length) {  //如果数组2已经遍历完，则取数组1，数组1索引加1
				curr = nums1[idx1];
				idx1++;
			} else {			//如果两个数组都未遍历完
				if (nums1[idx1] < nums2[idx2]) {  //数组1的元素小于数组2的元素，则取数组1的元素，反之取数组2的元素
					curr = nums1[idx1];
					idx1++;
				} else {
					curr = nums2[idx2];				
					idx2++;
				}
			}
			idx++;
		}
		if (total % 2 == 0) { //如果两数组合后长度为偶数，则需要取中间两个平均数，需要再取下一个
			if (idx1 >= nums1.length) {
				return (curr + nums2[idx2]) / 2;
			} else if (idx2 >= nums2.length) {
				return (curr + nums1[idx1]) / 2;
			} else {
				return (curr + (nums1[idx1] < nums2[idx2] ? nums1[idx1] : nums2[idx2])) / 2;
			}
		}
		return curr;
	}

}
