package org.xwl.demos.leetcode;

import com.xwl.leetcode.ShortestPalindrome;

import junit.framework.TestCase;

public class ShortestPalindromeTest extends TestCase{
	
	public void testReturnAtFirst() {
		String s1 = "d";
		String s2 = "bb";
		String s3 = "cc";
		assertEquals(ShortestPalindrome.shortestPalindrome(s1),s1);
		assertEquals(ShortestPalindrome.shortestPalindrome(s2),s2);
		assertEquals(ShortestPalindrome.shortestPalindrome(s3),s3);
	}
	
	
	public void testPalindrome(){
		String s = "abcdeffedcba";
		assertEquals(ShortestPalindrome.shortestPalindrome(s),"abcdeffedcba");	
	}
	
	public void testCust() {
		String s = "abcdefghijak";
		String target = "kajihgfedcbabcdefghijak";
		assertEquals(ShortestPalindrome.shortestPalindrome(s),target);		
	}

	public void testCust2() {
		String s = "baabcdefghijk";
		String target = "kjihgfedcbaabcdefghijk";
		assertEquals(ShortestPalindrome.shortestPalindrome(s),target);		
	}

	public void testCust3() {
		String s = "baabcdefghabijk";
		String target = "kjibahgfedcbaabcdefghabijk";
		assertEquals(ShortestPalindrome.shortestPalindrome(s),target);		
	}
	
	public void testUnique() {
		String s = "abcdefghijk";
		assertEquals(ShortestPalindrome.shortestPalindrome(s),"kjihgfedcbabcdefghijk");
	}
	
	public void testEvenLen() {
		String s0 = "aaaa";
		String s1 = "ab";		
		String s2 = "aabb";
		String s3 = "acac";
		String s4 = "accb";
		String s5 = "acca";
		String s6 = "aaabcd";
		String s7 = "acaccallacacbbll";
//		llbbcacallaccacaccallacacbbll
//		assertEquals(ShortestPalindrome.shortestPalindrome(s0),"aaaa");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s1),"bab");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s2),"bbaabb");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s3),"cacac");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s4),"bccaccb");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s5),"acca");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s6),"dcbaaabcd");
		assertEquals(ShortestPalindrome.shortestPalindrome(s7),"llbbcacallaccacaccallacacbbll");
		
	}
	
	public void testOddLen() {
		String s0 = "aaaba";
		String s1 = "abc";		
		String s2 = "aaabb";
		String s3 = "acdac";
		String s4 = "abcbefjo";		
		String s5 = "accacca";
		String s6 = "aaabccddd";
		String s7 = "ccbaccaghaabccddabcbefjoH";
		String sO = "caccagh";
		String s8 = "aba";
//		assertEquals(ShortestPalindrome.shortestPalindrome(s0),"abaaaba");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s1),"cbabc");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s2),"bbaaabb");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s3),"cadcacdac");
		assertEquals(ShortestPalindrome.shortestPalindrome(s4),"ojfebcbabcbefjo");
//		assertEquals(ShortestPalindrome.shortestPalindrome(s5),"accacca");
		assertEquals(ShortestPalindrome.shortestPalindrome(s6),"dddccbaaabccddd");
		assertEquals(ShortestPalindrome.shortestPalindrome(s7),"HojfebcbaddccbaahgaccabccbaccaghaabccddabcbefjoH");
		assertEquals(ShortestPalindrome.shortestPalindrome(s8),"aba");
		
	}	


}
