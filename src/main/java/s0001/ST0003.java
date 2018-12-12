package s0001;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.*;

public class ST0003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer preValue = map.put(s.charAt(i), i);
            if (preValue != null && preValue >= start) {
                start = preValue+1;
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}
