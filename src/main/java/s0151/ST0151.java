package s0151;
/*
151. Reverse Words in a String
Medium

Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".

Note:

    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.

Follow up: For C programmers, try to solve it in-place in O(1) space.

 */
public class ST0151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = s.length(); j > 0; j--) {
            if (s.charAt(j-1)!=' ') {//found a word end
                //find start
                for (int i = j-1; i >=0; i--) {
                    if (i==0 || s.charAt(i-1)==' ') {
                        //found start
                        if (sb.length() > 0) {
                            sb.append(' ');
                        }
                        sb.append(s.substring(i, j));
                        j=i;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
