package com.xwl.leetcode;

import java.util.LinkedList;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 2

4->2, 6->4, 8->8, 

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()))"
Output: 6
 
 
Input: "(()(()))((()))"
Input: "( (  ))((  ))"
 
Note:
S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50

(((((((((((((((((((((((()))))))))))))))))))))))))
 * @author xwl
 *
 */


public class ScoreOfParentheses {
    
    /**
     * 官方答案
     * 发现我的解决方案增加了复杂度，凭空多了数值需要判断
     * 官方这个思路就真的及其简明和精巧了
     * 总的来说就是算出每一个“()”嵌套层次和对应的最终值，并一一相加
     * @param S
     * @return
     */
    public static int scoreOfParentheses(String S) {
//        if(S.replace("()","").length()==0) return S.length()/2;
        int ans = 0, nesting = 0;
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                nesting++;
            } else {
                nesting--;
                if (s[i-1] == '(') ans += 1 << nesting;                
            }            
            if(nesting==s.length/2)  return 1<<(nesting-1);
        }
        return ans;
    }
    
    
    /**
     * Runtime: 9 ms, faster than 7.92% of Java online submissions for Score of Parentheses.
       Memory Usage: 37.2 MB, less than 17.95% of Java online submissions for Score of Parentheses.
       成功是成功了，但是效率太差了，内存也使用不少
     * @param S
     * @return
     */
    public static int scoreOfParentheses_v1(String S) {
        //all single balanced parentheses 
        if(S.replace("()","").length()==0) return S.length()/2;
        if(S.substring(0, S.length()/2).replace("(", "").length() == 0) return 2<<(S.length()/2-2);
        S = S.replace("()", "1").replace("(1)", "2").replace("(2)", "4").replace("(4)", "8");
        LinkedList<String> rest = new LinkedList<>();
        char[] tmp = S.toCharArray();     
        for(int i=0;i<tmp.length;i++) {
            rest.add(String.valueOf(tmp[i]));
        }
        int i = 0;
        while(rest.size()>1) {
          //当前元素为数值时
            if(!"(".equals(rest.get(i)) && !")".equals(rest.get(i))) {
                //如果前面元素也是数值
                while(i>0 && !"(".equals(rest.get(i-1)) && !")".equals(rest.get(i-1))){                    
                    //那么将下个元素值添加到当前位置，并且移除下个元素
                    rest.add(i-1, ""+(Integer.parseInt(rest.get(i-1))+Integer.parseInt(rest.get(i))));                    
                    rest.remove(i+1);
                    rest.remove(i);
                    i--;
                }
                //如果下个元素也是数值
                while(i<rest.size()-1 && !"(".equals(rest.get(i+1)) && !")".equals(rest.get(i+1))){                    
                    //那么将下个元素值添加到当前位置，并且移除下个元素
                    rest.add(i, ""+(Integer.parseInt(rest.get(i))+Integer.parseInt(rest.get(i+1))));                    
                    rest.remove(i+2);
                    rest.remove(i+1);
                }
                if((i<rest.size()-1) && "(".equals(rest.get(i+1))){
                    i++;
                }else {
                    //如果当前元素与前后元素构成(A)组合，则在三个元素前插入值为A*2的元素
                    //并且将前面三个移除，i后移一位
                    while (i>0 && i<rest.size()-1 && "(".equals(rest.get(i-1)) && ")".equals(rest.get(i+1))){
                        rest.add(i-1, ""+Integer.parseInt(rest.get(i))*2);
                        rest.remove(i+2);
                        rest.remove(i+1);
                        rest.remove(i);
                        i--;
                    }                    
                }
            }else {
                i++;    
            }
        }                
        return Integer.parseInt(rest.get(0));
    }
    
    public static void main(String[] args) {
        
        
    }
    
    
}
