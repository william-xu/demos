package org.xwl.demos.leetcode;

import org.xwl.demo.leetcode.FindtheTownJudge;

import junit.framework.TestCase;

public class FindtheTownJudgeTest extends TestCase{
    public void testJ1() {
        int N = 5;
        int[][] trust = new int[][]{{4,1},{2,1},{5,1},{3,1},{4,2},{4,1}};
        assertTrue(FindtheTownJudge.findJudge(N, trust)==1);
    }

    public void testJ2() {
        int N = 5;
        int[][] trust = new int[][]{{4,1},{2,1},{5,1},{3,4}};
        assertTrue(FindtheTownJudge.findJudge(N, trust)==-1);
    }

    
    public void testJ3() {
        int N = 5;
        int[][] trust = new int[][]{{4,3},{2,1},{5,1}};
        assertTrue(FindtheTownJudge.findJudge(N, trust)==-1);
    }
    
    public void testJ4() {
        int N = 5;
        int[][] trust = new int[][]{{4,3},{2,5},{5,1},{1,3},{2,3},{5,3}};
        assertTrue(FindtheTownJudge.findJudge(N, trust)==3);
    }    

    public void testJ5() {
        int N = 1;
        int[][] trust = new int[][]{};
        assertTrue(FindtheTownJudge.findJudge(N, trust)==1);
    }
    
}
