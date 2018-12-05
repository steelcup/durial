package s0000;

/*
14. Longest Common Prefix
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

import java.util.*;

public class ST0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        int i = 0;
        int lastIdx = strs.length-1;
        while (i < strs[0].length() && i < strs[lastIdx].length() && strs[0].charAt(i)== strs[lastIdx].charAt(i)) {
            i++;
        }
        return strs[0].substring(0, i);
    }
}
