package s0051;
/*
81. Search in Rotated Sorted Array II
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:

    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?


 */
public class ST0081 {
    public boolean search(int[] nums, int target) {
        if (nums==null || nums.length==0) {
            return false;
        }

        int from = 0, to = nums.length-1, m;
        while (from <= to) {
            m = from +(to-from)/2;
            if (nums[m]==target) {
                return true;
            }
            if (nums[m] < nums[to] || nums[from] > nums[m]) {//right sorted
                if (target > nums[m] && target <= nums[to]) {
                    from = m+1;
                } else {
                    to = m-1;
                }
            } else if (nums[from] < nums[m] || nums[m] > nums[to]) {//left sorted
                if (target >= nums[from] && target < nums[m]) {
                    to = m-1;
                } else {
                    from = m+1;
                }
            } else {
                to--;
            }
        }
        return false;
    }
}
