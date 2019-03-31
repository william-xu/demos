package org.xwl.demos.leetcode;

import com.xwl.leetcode.LongestPalindromicSubstring;

import junit.framework.TestCase;

public class LongestPalindromicSubstringTest extends TestCase{

    public void testReturnAtFirst() {
        String s1 = "d";
        String s2 = "bb";
        String s3 = "cc";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s1),s1);
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s2),s2);
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s3),s3);
    }
    
    
    public void testPalindrome(){
        String s = "abcdeffedcba";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),"abcdeffedcba");   
    }
    
    public void testCust() {
        String s = "abcdefghijak";
        String target = "b";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }

    public void testCust2() {
        String s = "baabcdefghijk";
        String target = "baab";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }

    public void testCust3() {
        String s = "baabcdefghabijk";
        String target = "baab";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }
    

    public void testCust4() {
        String s = "eabcb";
        String target = "bcb";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }
    
    public void testCust5() {
        String s = "aaabaaaa";
        String target = "aaabaaa";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }
    
    public void testCust6() {
        String s = "222020221";
        String target = "2202022";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),target);       
    }
    
    
    
    public void testUnique() {
        String s = "abcdefghijk";
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s),"");
    }
    
    public void testEvenLen() {
        String s0 = "aaaa";
        String s1 = "ab";       
        String s2 = "aabb";
        String s3 = "acac";
        String s4 = "accceeffb";
        String s5 = "abaaaabd";
        String s6 = "aaabcd";
        String s7 = "acaccallacacbbll";
//      llbbcacallaccacaccallacacbbll
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s0),"aaaa");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s1),"a");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s2),"aa");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s3),"aca");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s4),"ccc");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s5),"baaaab");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s6),"aaa");
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s7),"callac");
        
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
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s0),"abaaaba");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s1),"cbabc");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s2),"bbaaabb");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s3),"cadcacdac");
//        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s4),"bcb");
//      assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s5),"accacca");
//        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s6),"dddccbaaabccddd");
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s7),"acca");
        assertEquals(LongestPalindromicSubstring.getLongestPalindrome(s8),"aba");
        
    }   
}
