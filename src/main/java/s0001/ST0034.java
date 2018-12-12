package s0001;

/*
34. Find First and Last Position of Element in Sorted Array
Medium

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


 */

import java.util.*;

public class ST0034 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        //java binarySearch. to is excluded
        int idx = Arrays.binarySearch(nums, 0, nums.length, target);
        if (idx < 0) {
            return ret;
        }
        ret[0]=idx;
        ret[1]=idx;
        int n = idx;
        while ((n = Arrays.binarySearch(nums, 0, n, target))>=0) {
            ret[0] = n;
        }
        n = idx;
        while ((n = Arrays.binarySearch(nums, n+1, nums.length, target))>=0) {
            ret[1]=n;
        }
        return ret;
    }
}
