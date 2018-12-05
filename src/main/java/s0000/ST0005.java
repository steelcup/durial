package s0000;

/*
5. Longest Palindromic Substring
Medium

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"


 */

public class ST0005 {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==1) {
            return s;
        }
        int len = s.length();
        char[]cs = s.toCharArray();
        String ret = "";
        for (int i = 0; i < len; i++) {
            String s1 = this.expand(cs, i, i);
            if (s1.length() > ret.length()) {
                ret = s1;
            }
            if (i < len-1 && cs[i]==cs[i+1]) {
                String s2 = this.expand(cs, i, i+1);
                if (s2.length() > ret.length()) {
                    ret = s2;
                }
            }//else if expend the last one, the result string will be just one char
        }
        return ret;
    }

    private String expand(char[] cs, int left, int right) {
        while(left > 0 && right < cs.length-1 && cs[left-1]==cs[right+1]) {
            left--;
            right++;
        }
        return new String(cs, left, right-left+1);
    }
}
