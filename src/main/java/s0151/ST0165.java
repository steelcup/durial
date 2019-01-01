package s0151;
/*
165. Compare Version Numbers
Medium

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1

Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
 */
public class ST0165 {
    public int compareVersion(String version1, String version2) {
        String[] tks1 = version1.split("\\.");
        String[] tks2 = version2.split("\\.");
        int i=0;
        while (i < tks1.length || i < tks2.length) {
            int c1 = i < tks1.length? Integer.parseInt(tks1[i]): 0;
            int c2 = i < tks2.length? Integer.parseInt(tks2[i]): 0;
            if (c1==c2) {
                i++;
            } else {
                return Integer.compare(c1, c2);
            }
        }
        return 0;
    }
}
