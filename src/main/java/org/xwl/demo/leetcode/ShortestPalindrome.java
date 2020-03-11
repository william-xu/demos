package org.xwl.demo.leetcode;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: "abcd"
Output: "dcbabcd"
 * @author xwl
 * @memo 就leetcode给出的样例数据，两个方法执行时间和内存几乎一样
 *
 */
public class ShortestPalindrome {
	
	/**
	 * 这个方法的思路也是寻找轴心字符串,不过使用迭代方式
	 * 
	 * @param s
	 * @return
	 */
	public static String shortestPalindrome(String s) {
	    //从尾到头跟开始元素逐个比较，例如对于： abcdefgabc 从后面往前遍历，从第一个元素起往后遍历，当遍历到 c->b->a 时，跟第一个元素相等，匹配个数+1
		//再继续从(abcdefg)中跟 开头的第二个元素b进行比较看有无相等，直到结束。 如果是完整的回文，那么两两匹配个数会等于回文长度,
	    //由于题目是要在前面补充，那么说明缺少的都是前面部分，假设当前回文结构 ABACAD（ABAABACAD）,==> 对于子回文结构ABA（ABAABA），至少会有n个两两匹配（n=子回文长度)
		//，即（A=A,B=B,A=A)/(A=A,B=B,A=A,A=A,B=B,A=A)，当不是完整的回文时，两两匹配个数即子回文的最大长度，剩余的则是需要补充的				
		int match = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(match)) {
	        	match++;
	        }
	    }
	    //全部是唯一的字符
	    if(match == 1) return new StringBuffer(s.substring(match)).reverse().append(s).toString();
	    //是完整的回文结构
	    if (match == s.length()) { return s; }
	    //存在部分回文结构
	    String suffix = s.substring(match);  //获取子回文后面字符串
	    //将后面字符串反转+假设的子回文迭代返回的字符串+后面字符串构成完整的回文字符串
	    return new StringBuffer(suffix).reverse().append(shortestPalindrome(s.substring(0, match))).append(suffix).toString();	    
	}
	
	//思路：找到中心轴字符串，m0和m1用来标识轴字符串的起始和结束，并且从中部开始假设为轴
	/**
	 * 如果直接使用操作s字符串，不使用sc数组的话，会明显慢很多
	 *  Runtime: 2 ms, faster than 88.25% of Java online submissions for Shortest Palindrome.
        Memory Usage: 35 MB, less than 78.57% of Java online submissions for Shortest Palindrome.
	 * @param s
	 * @return
	 */
    public static String shortestPalindrome_v1(String s) {
		if (s.length() <= 1) return s;
		if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.charAt(1) + s;

    	int m0 = s.length()/2, m1 = m0; //m0是轴字符串前面的索引，初始为中间索引（偶数长度+1），以中间字符或相同字符串为假定轴,m1是轴字符/字符串结束索引
    	int tmp = 0;
    	char[] sc = s.toCharArray();
		while(m0>0 && m1<sc.length) {
			while(m0 > 0 && sc[m0] == sc[m0-1])  m0--;	   			//m0向左推进
			while((m1 <sc.length-1) && (sc[m0]==sc[m1+1])) m1++;	//m1向右推进
			tmp = m0;//临时变量保存轴起始
			//向两侧扩散比较，
			while(m0 > 0 && m1<sc.length-1 && sc[m0-1] == sc[m1+1]) { //如果假定轴两侧字符相等，则索引向两边扩散
				m0--;m1++;
			}
			//如果比较完首尾各自等于开始和结束索引，那么说明是完整的回文，直接返回
			if(m0 == 0 && m1 == sc.length-1) return s;
			//如果假定的轴字符串起始不等于0，说明假定是错的，将假定轴字符串前移一位
			if (m0 >0) {
				m0=tmp-1;m1=m0;
			}
		}
        StringBuilder sb = new StringBuilder(""); 
        for (int i = sc.length - 1; i > m1; i--) {
            sb.append(sc[i]);
        }
        String p =sb.append(s).toString();
        return p;
    }
    
}
