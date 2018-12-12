package s0001;

/*
10. Regular Expression Matching
Hard

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false


 */
public class ST0010 {
    //https://www.youtube.com/watch?v=l3hda49XcDE
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        char[]text = s.toCharArray(), pattern = p.toCharArray();
        boolean[][]dp = new boolean[text.length+1][pattern.length+1];
        dp[0][0] = true;
        //deal with pattern like a* or a*b*
        for (int i = 2; i < dp[0].length; i++) {//** is not a legal reg.  * cannot be at the first one, so starting checking from second one
            if (pattern[i-1]=='*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j-1]=='.' || pattern[j-1]==text[i-1]) {
                    dp[i][j] = dp[i-1][j-1]; //if match, check up-left
                } else if (pattern[j-1]=='*') {
                    if (dp[i][j-2]) {
                        dp[i][j]=true;
                    } else if (pattern[j-2] == '.' || pattern[j-2] == text[i-1]) {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][pattern.length];
        /*
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
        */

    }
}
