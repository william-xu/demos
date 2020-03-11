package org.xwl.demo.algorithm;

public class QuickSort {

	/**
	 * 递归快速排序
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quicksort(int[] arr, int start, int end) {
		if((end - start)<2) return; //递归退出条件		
		int p = partition(arr, start, end);
		//以pivot元素为中心，将数组分成两个区间分别进行递归
		quicksort(arr, start, p-1);
		quicksort(arr, p+1, end);
	}

	public static int partition(int[] arr, int start, int end) {
		int s = start, e = end, p = arr[s];		
		while(s < e) {
			while(s < e && arr[e] > p) e--;
			if(s < e) arr[s++] = arr[e];
			while(s < e && arr[s] < p) s++;
			if(s < e) arr[e--] = arr[s];
		}
		arr[s] = p;
		
		return s;
	}

}
