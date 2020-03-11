package org.xwl.demo.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 * @author xwl
 *
 */
public class MatrixOf01 {
    
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //先记录所有0所在位置，并将其他位置值修改为java所能表示最大正数值，如果按照题目所规定，那么值修改为1万即可。
        //即从最小的开始，将所有0保存到队列中
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        //对队列中的元素逐个取出并比较上下左右的数，如果与当前元素值相等或者大1，则继续
        //否则将不等的元素位置添加到队列并且将该元素设置为当前元素值+1，
        //如此循环直到所有元素都遍历完
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                System.out.println("new coor is : " + r + "," + c);
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }    
    
    
    public static int[][] updateMatrix_v1(int[][] matrix) {
        int currZidx = -1, prevZidx = -1, dis = -1;
        int[] zeros = new int[matrix[0].length];
        for(int i=0;i<zeros.length;i++) {
            zeros[i] = -1;
        }
        List<Integer> allOne = new LinkedList<>();
        for(int i=0;i<matrix.length; i++) {
            currZidx = -1; prevZidx = -1;
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j] == 0) {
                    if(zeros[j] == -1) {
                        zeros[j]=i;
                    }
                    if(currZidx == -1) {
                        currZidx = j;
                        for(int k = j-1;k>=0;k--) {
                            matrix[i][k] = matrix[i][k]+j-k-1;
                        }
                    }else {
                        prevZidx = currZidx;
                        currZidx = j;
                        dis = currZidx - prevZidx;
                        if(dis > 3) {
                            for(int k=1;k<=dis/2;k++) {
                                matrix[i][prevZidx+k]=matrix[i][prevZidx+k]+k-1;
                                matrix[i][currZidx-k]=matrix[i][currZidx-k]+k-1;
                            }
                            if(dis%2 == 0) {
                                matrix[i][prevZidx+dis/2]--;
                            }
                        }
                    }
                }else if(j==matrix[i].length-1){ //达到终点
                    if(currZidx != -1 && j-currZidx>1) {
                        dis = j-currZidx;
                        while(dis > 0) {
                            matrix[i][currZidx+dis] += dis-1;
                            dis--;
                        }
                    }else if(currZidx == -1){
                        allOne.add(i);
                    }
                }
            }
        }
        pm(matrix);
        int val;
        for(int col=0;col<zeros.length;col++) {
            currZidx = zeros[col];
            if(col == 3) {
                System.out.println("fff");
            }
            if(currZidx>0) { //up
                prevZidx = currZidx-1;
                while(prevZidx >= 0) {
                    val = currZidx - prevZidx;
                    if(allOne.contains(prevZidx)) {
                        matrix[prevZidx][col] = val;
                    }else if(val < matrix[prevZidx][col]){
                        matrix[prevZidx][col] = val;
                    }
                    prevZidx--;
                }
            }

            if(currZidx<matrix.length-1) { //down
                prevZidx = currZidx;
                for(int i=currZidx+1;i<matrix.length;i++) {
                    if(matrix[i][col] == 0) {
                        currZidx = i;
                        dis = currZidx - prevZidx;
                        if(dis > 1) {
                            for(int k=1;k<=dis/2;k++) {
                                val = k;
                                if(allOne.contains(prevZidx+k)) {
                                    matrix[prevZidx+k][col]=val;    
                                }else if(matrix[prevZidx+k][col] > val) {
                                    matrix[prevZidx+k][col] = val;
                                }
                                if(dis%2 != 0 || (dis%2 == 0 && k != dis/2)) {
                                    if(allOne.contains(currZidx-k)) {
                                        matrix[currZidx-k][col]=val;    
                                    }else if(matrix[currZidx-k][col] > val) {
                                        matrix[currZidx-k][col] = val;
                                    }
                                }
                            }                    
                        }
                        prevZidx = currZidx;                        
                    }else if(i==matrix.length-1){ //end                        
                        dis = matrix.length-1-currZidx;
                        for(int k=1;k<=dis;k++) {
                            if(allOne.contains(k)) {
                                matrix[currZidx+k][col] = k;
                            }else if(matrix[currZidx+k][col] > k){
                                matrix[currZidx+k][col] = k;
                            }                            
                        }
                    }
                }    
            }            
        }
        
        return matrix;
    }
    
    
    public static void pm(int[][] a) {
        System.out.println();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
    }    
    
}
