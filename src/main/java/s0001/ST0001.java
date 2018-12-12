package s0001;

/*
1. Two Sum
Easy
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

import java.util.*;

public class ST0001 {
    public int[] twoSum(int[]a, int target) {

        if (a == null || a.length<2) {
            return null;
        }
        int[] ret = new int[2];
        //(value, index)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a[0],  0);
        for (int i = 1; i < a.length; i++) {
            int diff = target-a[i];
            if (map.containsKey(diff)) {
                ret[0] = map.get(diff);
                ret[1] = i;
                return ret;
            }
            map.put(a[i],  i);
        }
        return ret;

        //using two pointers  (cannot sort because this question require return index not value)
       /*
       Arrays.sort(a);
       int i = 0, j = a.length-1;
       while(i < j) {
           int v = a[i] + a[j];
           if (v == target) {
               return new int[]{i, j};
           }
           if (v > target) {
               j--;
           } else {
               i++;
           }
       }
       return new int[]{-1, -1};
       */
    }
}
