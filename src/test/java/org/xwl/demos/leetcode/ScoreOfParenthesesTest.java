package org.xwl.demos.leetcode;

import com.xwl.leetcode.ScoreOfParentheses;

import junit.framework.TestCase;

public class ScoreOfParenthesesTest extends TestCase{
    
    public void testAllbalanced() {
        assertEquals(ScoreOfParentheses.scoreOfParentheses("()"),1);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("()()"),2);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("()()()"),3);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("()()()()()()()()()()()()"),12);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("()()()()()()()()()()()()()()()()()()()()()()()()()"),25);        
    }
    
    public void testAllPower() {
        assertEquals(ScoreOfParentheses.scoreOfParentheses("(())"),2);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("((()))"),4);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("((((()))))"),16);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("(((((())))))"),32);
        assertEquals(ScoreOfParentheses.scoreOfParentheses("(((((((((((((((((((((((()))))))))))))))))))))))))"),8388608);        
    }
    
    public void testExample1() {
        String s1 = "(()(()))";    
        assertEquals(ScoreOfParentheses.scoreOfParentheses(s1),6);
    }
    
    public void testExample2() {
        String s1 = "(()(()))((()))";    
        assertEquals(ScoreOfParentheses.scoreOfParentheses(s1),10);
    }
    
    public void testExample3() {
        String s1 = "(()()())()"; 
        assertEquals(ScoreOfParentheses.scoreOfParentheses(s1),7);
    }
    
    public void testExample4() {
        String s1 = "()(())()(((()(()())))(((())(()))()))(((())))";    
        assertEquals(ScoreOfParentheses.scoreOfParentheses(s1),88);
    }
    
    
//    "()(())()(((()(()())))(((())(()))()))(((())))"
    

//        Example 4:
//        Input: "(()(()))"->(1(1))->(12)->(3)->6
//        Output: 6
//         
//  "(()()())()"  -> (111)1->(3)1->7
    
//        Input: "(()(()))((()))" ->(1(1))((1))->(12)(2)->64->10
    
}
