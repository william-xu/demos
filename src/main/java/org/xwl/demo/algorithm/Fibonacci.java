package org.xwl.demo.algorithm;

public class Fibonacci {

	/**
	 * 构造最大值<=max值的斐波那契数列
	 * 斐波那契数列是一个数列从第3项开始，每一项都等于前两项之和。
	 * 
	 * @param n1   数列第一个数值
	 * @param n2   数列第二个数值
	 * @param max  数列最大值 <= max 
	 * @return
	 */
	public static String getFibonacci(long n1, long n2, long max) {		
		long next = n1 + n2;
		return next >= max ? "" : (next == 2 ? "1,1" : "") + "," + next + getFibonacci(n2, next, max);
	}

}
