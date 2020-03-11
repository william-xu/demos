package org.xwl.demo.algorithm;

public class BubbleSort {

	//冒泡排序
	public static void bubblesort(int[] arr) {
		int tmp;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	//不用临时变量
	public static void bubblesort2(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					arr[i] = arr[i]^arr[j];
					arr[j] = arr[i]^arr[j];
					arr[i] = arr[i]^arr[j];
				}
			}
		}
	}
	
	
	
}
