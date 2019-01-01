package s0151;
/*
163. Missing Ranges
Medium

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
 */
import java.util.*;

public class ST0163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        long pre = (long)lower-1, v, d;
        for (int i = 0; i < nums.length; i++) {
            v = nums[i];
            d = v-pre;
            if (d==2) {
                list.add(Long.toString(v-1));
            } else if (d > 2) {
                list.add(String.format("%d->%d", pre+1, v-1));
            }
            pre = nums[i];
        }
        v = upper;
        d = upper-pre;
        if (d==1) {
            list.add(Long.toString(v));
        } else if (d > 1) {
            list.add(String.format("%d->%d", pre+1, v));
        }
        return list;
    }
}
