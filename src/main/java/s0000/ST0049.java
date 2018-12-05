package s0000;

/*
49. Group Anagrams
Medium

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.


 */

import java.util.*;

public class ST0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        int[] c = new int[26];
        for (String s : strs) {
            Arrays.fill(c, 0);
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i)-'a']++;
            }
            int hashCode = Arrays.hashCode(c);
            map.computeIfAbsent(hashCode, k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
