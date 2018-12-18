package s0101;
/*
127. Word Ladder
Medium

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */
import java.util.*;

public class ST0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        /*
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        //BFS with cache, and find shortest depth
        q.add(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            count++;
            for (int i = 0; i < len; i++) {
                String s = q.remove();
                if (s.equals(endWord)) {
                    return count;
                }
                for (String w : wordList) {
                    if (visited.contains(w)) {
                        continue;
                    }
                    if (hasOneDelta(s, w)) {
                        visited.add(w);
                        q.add(w);
                    }
                }
            }
        }
        return 0;
        */
        //another way is to switch one of the begin letter, and find if that exist in the dict list
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int len = q.size();
            while (len > 0) {
                String s = q.remove();
                if (s.equals(endWord)) {
                    return level;
                }
                char[]cs = s.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char tmp = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == c) {
                            continue;
                        }
                        cs[i] = c;
                        String ts = new String(cs);
                        if (dict.contains(ts)) {
                            q.add(ts);
                            dict.remove(ts);
                        }
                    }
                    cs[i] = tmp;
                }
                len--;
            }
        }
        return 0;
    }

    private boolean hasOneDelta(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    break;
                }
            }
        }
        return count==1;
    }
}
