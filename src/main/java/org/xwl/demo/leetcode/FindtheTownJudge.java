package org.xwl.demo.leetcode;

import java.util.LinkedList;

/**
 * 997. Find the Town Judge
 * Difficulty: Easy
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1.The town judge trusts nobody.
2.Everybody (except for the town judge) trusts the town judge.
3.There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

 * @author nozuodie
 *
 */
public class FindtheTownJudge {
    
    public static int findJudge(int N, int[][] trust) {
        return findJudge_v2(N,trust);
    }
    
    /**
     * Runtime: 32 ms, faster than 21.33% of Java online submissions for Find the Town Judge.
        Memory Usage: 64.5 MB, less than 100.00% of Java online submissions for Find the Town Judge.
     * @param N
     * @param trust
     * @return
     */
    public static int findJudge_v2(int N, int[][] trust) {
        if(N>1000 || N<1 || trust.length < N-1) return -1;   
        if(N == 1 && trust.length == 0) return 1;
        LinkedList<Integer> tmp = new LinkedList<>();
        int[] t = new int[N+1];
        for(int i=0;i<trust.length;i++){
            t[trust[i][0]]=-1;//如果person a 信任别人，那么必定不是法官
        }
        //确认法官
        int nonTrust = 0, judge=-1;
        for(int i=1;i<t.length;i++) {
            if(t[i] != -1)  {
                judge = i;
                nonTrust++;
            }
            //如果有超过两个人没有信任别人，那么不能确定这两个人哪个是法官
            if(nonTrust >1 ) {
                judge = -1;
                break;
            }
        }        
        //记录信任别人的所有人
        for(int i=0;i<trust.length;i++){
            if(trust[i][1] == judge && !tmp.contains(trust[i][0])) {
                tmp.add(trust[i][0]);
            }
        }

        if(tmp.size() != (N-1)) return -1;
        
        return judge;
    }
    
    /**
     * Runtime: 135 ms, faster than 5.15% of Java online submissions for Find the Town Judge.
    Memory Usage: 62.8 MB, less than 100.00% of Java online submissions for Find the Town Judge.
    Next challenges:
     * @param N
     * @param trust
     * @return
     */
    public static int findJudge_v1(int N, int[][] trust) {
        if(N>1000 || N<1 || trust.length < N-1) return -1;   
        if(N == 1 && trust.length == 0) return 1;
        int[] t = new int[N+1];
        LinkedList<LinkedList<Integer>> rel = new LinkedList<>();
        LinkedList<Integer> tmp;
        for(int i=0;i<=N;i++) {
            rel.add(null);
        }
        //记录信任别人的所有人
        for(int i=0;i<trust.length;i++){
            t[trust[i][0]]=-1;//如果person a 信任别人，那么必定不是法官
            tmp = rel.get(trust[i][1]);
            if(tmp == null) { //信任的人此时没有别人信任
                tmp = new LinkedList<>();
                rel.set(trust[i][1], tmp);
            }
            if(!tmp.contains(trust[i][1])) {
                tmp.add(trust[i][0]);    
            }
        }

        int nonTrust = 0, judge=-1;
        for(int i=1;i<t.length;i++) {
            if(t[i] != -1)  {
                judge = i;
                nonTrust++;
            }
            //如果有超过两个人没有信任别人，那么不能确定这两个人哪个是法官
            if(nonTrust >1 ) {
                judge = -1;
                break;
            }
        }
        if(judge != -1 && rel.get(judge).size()!=(N-1)) {       
            return -1;
        }
        
        return judge;
    }
    
    /**
     * 
     * @param N
     * @param trust
     * @return
     */
    public static int findJudge_v3(int N, int[][] trust) {
        //用N+1长度的数组中的后N个数组来对应N个村民，
        int[][] trustTable = new int[N+1][2]; 
        
        for (int i=0;i<trust.length; i++) {
            //每个数组有两个元素，第一个是第i个村民信任别人次数，第2个元素是被别人信任次数，这里的前提条件是村民信任关系没有重复
            trustTable[trust[i][0]][0]++;
            trustTable[trust[i][1]][1]++;
        }
        
        for (int i=1;i<trustTable.length;i++) {
            if (trustTable[i][0] == 0 && trustTable[i][1] == N-1) {
                return i;
            }
        }
        
        return -1;
    }    
    
}
