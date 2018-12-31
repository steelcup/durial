package s0151;
/*
159. Longest Substring with At Most Two Distinct Characters
Hard

Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */
public class ST0159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char a=0, b=0, c;
        int aCount=0, bCount=0, count=0, max=0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c==b) {
                count++;
                bCount++;
            } else if (c==a) {
                count++;
                aCount++;
                a=b;
                b=c;
                aCount=bCount;
                bCount=1;
            } else {
                a=b;
                b=c;
                aCount=bCount;
                count = bCount+1;
                bCount=1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
