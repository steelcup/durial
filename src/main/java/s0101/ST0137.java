package s0101;
/*
137. Single Number II
Medium

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3

Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
import java.util.*;

public class ST0137 {
    public int singleNumber(int[] a) {
        Arrays.sort(a);
        int i = 0;
        while (i < a.length) {
            if (i == a.length-1) {
                return a[i];
            }
            if (a[i] != a[i+1]) {//no need to check a[i]==a[i+2] because all others has 3 dup if a[i]==a[i+1], a[i+2] must be the same
                return a[i];
            }
            i += 3;
        }
        return -1;
    }
}
