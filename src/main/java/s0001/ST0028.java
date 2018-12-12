package s0001;

/*
28. Implement strStr()
Easy

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

 */
public class ST0028 {
    public int strStr(String a, String b) {
        if (a==null || b==null || a.length() < b.length()) {
            return -1;
        }
        if (b.isEmpty()) {
            return 0;
        }
        int aLen = a.length();
        int bLen = b.length();
        char c = b.charAt(0);
        int j ;
        for (int i = 0; i <= aLen-bLen; i++) {
            if (a.charAt(i)== c) {
                for (j = 1; j < bLen; j++) {
                    if (a.charAt(i+j)!=b.charAt(j)) {
                        break;
                    }
                }
                if (j==bLen) {
                    return i;
                }
            }
        }
        return -1;
    }
}
