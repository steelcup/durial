package s0051;

/*
58. Length of Last Word
Easy

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 */
public class ST0058 {
    public int lengthOfLastWord(String s) {
        int j = s.length()-1;
        while (j >= 0) {
            //find the first letter from the back
            if (Character.isLetter(s.charAt(j))) {
                //find the first non letter
                int k = j-1;
                while (k >= 0) {
                    if (Character.isLetter(s.charAt(k))) {
                        k--;
                    } else {
                        break;
                    }
                }
                return j - k;
            }
            j--;
        }
        return 0;
    }
}
