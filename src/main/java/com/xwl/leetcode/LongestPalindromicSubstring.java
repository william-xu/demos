package com.xwl.leetcode;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 * @author xwl
 *
 */
public class LongestPalindromicSubstring {
    
    /**
     * 官网方案
    Runtime: 9 ms, faster than 90.08% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 37.9 MB, less than 75.02% of Java online submissions for Longest Palindromic Substring.
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }    
    
    
    /**
     * 失败的解决方案
     * failed solution
     * 由于前一段时间做过在给定字符串前面添加最少的字符串构成完整的回文，参考那道题的递归方法，结果发现从一开始思路就错了
     * 递归中第一部分的循环比较只能确定残缺的回文的长度，但是不能确定残缺回文里面完整的子回文位置
     */
    public static String longestPalindrome_failed(String s) {
        System.out.println("当前字符串：："+s);
        char[] p = s.toCharArray();
        if(p.length == 1) return s;
        int match = 0, startIdx = 0, maxMatch = 0, mStartIdx = 0;
        while (startIdx < p.length-1 && maxMatch <= (p.length - startIdx)) {
            for (int i = p.length - 1; i >= startIdx; i--) {
                if (p[i] == p[startIdx+match]) match++;
            }
            // 全部匹配，说明是完整的回文，直接返回
            if (match == (p.length - startIdx)) return s;
            System.out.println("截取字符串::" + s.substring(startIdx, startIdx+match));
            boolean isP = true;
            int j = startIdx, counter=0;
            while(j<(startIdx+match)/2 && isP) {// acac callacacbbll
                System.out.println(p[j] + "-----"+p[startIdx+match-j-1]);
                if(p[j]==p[startIdx+match-counter-1]) {
                    j++;counter++;
                    if(counter>(startIdx+match)/2) break;
                }else {
                    isP = false;
                }
            }
            
            if (match > maxMatch && isP){
                maxMatch = match;
                mStartIdx = startIdx;                    
            }
            startIdx++;
            match = 0;
        }

        return s.substring(mStartIdx, mStartIdx+maxMatch);
    }

    /**
     * Runtime: 6 ms, faster than 99.52% of Java online submissions for Longest Palindromic Substring.
       Memory Usage: 37.9 MB, less than 79.12% of Java online submissions for Longest Palindromic Substring.
     * @param s
     * @return
     */
    public static String getLongestPalindrome(String s) {
        if (s.length() <= 1) return s;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);

      //m记录中点位置，m0是轴字符串前面的索引，初始为中间索引（偶数长度+1），以中间字符或相同字符串为假定轴,m1是轴字符/字符串结束索引
        int m = s.length()/2, m0 = m,  m1 = m; 
        boolean lreach = false;
        boolean rreach = false;
        int tmp = 0;        
        char[] sc = s.toCharArray();
        String longest = "";
        while(!lreach || !rreach) {
            tmp = m0;//临时变量保存轴起始
            while(m0 > 0 && sc[m0] == sc[m0-1])  m0--;              //m0向左推进
            while((m1 <sc.length-1) && (sc[m0]==sc[m1+1])) m1++;    //m1向右推进            
            //向两侧扩散比较，
            while(m0 > 0 && m1<sc.length-1 && sc[m0-1] == sc[m1+1]) { //如果假定轴两侧字符相等，则索引向两边扩散
                m0--;m1++;
            }
            //如果比较完首尾各自等于开始和结束索引，那么说明是完整的回文，直接返回
            if(m0 == 0 && m1 == sc.length-1) return s;
            if(longest.length()<(m1+1-m0)) {
                longest = s.substring(m0,m1+1);
            }

            if (m0 >0 && !lreach) {//先从左边开始遍历
                m0=tmp-1;m1=m0;
            }else if(m0 == 0 && !lreach) {
                lreach = true;
                m0 = m+1;m1=m0;
            }else if(m1<sc.length-1 && !rreach) {
                m0 = tmp+1; m1 = m0;
            }else if(m1 == sc.length-1 && !rreach) {
                rreach = true;
            }
        }
        //如果最长回文长度为1（说明给定字符串没有重复出现）则返回第一个字母
        return longest.length() == 1 ? s.substring(0,1) : longest;
    }    
    
}
