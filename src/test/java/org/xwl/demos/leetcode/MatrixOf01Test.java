package org.xwl.demos.leetcode;

import com.xwl.leetcode.MatrixOf01;

import junit.framework.TestCase;

public class MatrixOf01Test extends TestCase{
    
    public void testC1() {
        int[][] a = new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,0,1,1},{1,1,1,1,1,0}};
        MatrixOf01.updateMatrix(a);
        pm(a);
    }

    
    public void testC2() {
        int[][] a = new int[][] {{0},{0},{0},{0},{0}};
        MatrixOf01.updateMatrix(a);
        pm(a);
    }

    public void testC3() {
        int[][] a = new int[][] {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        pm(a);
        MatrixOf01.updateMatrix(a);
        pm(a);
    }
    
    public void testC4() {
        int[][] a = new int[][] {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        pm(a);
        System.out.println();
        MatrixOf01.updateMatrix(a);
        pm(a);
        int[][] e = new int[][] {{0,0,1,0,1,2,1,0,1,2},{1,1,2,1,0,1,1,1,2,3},{2,1,2,1,1,0,0,0,1,2},{1,0,1,0,1,1,1,0,1,2},{0,0,1,1,1,0,1,1,2,3},{1,0,1,2,1,1,1,2,1,2},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,2},{1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,2,1,0}};
        System.out.println();
        pm(e);
    }    
    
    
    public static void pm(int[][] a) {
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
    }
    
    
    
    
    
}
