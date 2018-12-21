package s0101;

/*
139. Word Break
Medium

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import org.junit.jupiter.api.Test;

import java.util.*;

public class ST0139 {
    Map<String, Boolean> map = new HashMap<>();
    @Test
    public void test() {
        //List<String> dicts = new ArrayList(Arrays.asList("leet", "code"));
        //System.out.println(wordBreak("leetcode", dicts));

        List<String> dicts = new ArrayList(Arrays.asList("apple", "pen"));
        System.out.println(wordBreak("applepenapple", dicts));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                if (wordBreak(s.substring(w.length()), wordDict)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
