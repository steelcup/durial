package s0001;

/*
33. Search in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


 */
public class ST0033 {
    public int search(int[] nums, int target) {
        int from = 0, to = nums.length-1;
        while (from <= to) { // <=
            int m = (from+to)/2;
            if (target==nums[m]) {
                return m;
            }
            if (nums[to] > nums[m]) {
                if (target > nums[m] && target <= nums[to]) {
                    from = m+1;
                } else {
                    to = m-1;
                }
            } else { //left sorted
                if (target >= nums[from] && target < nums[m]) {
                    to = m-1;
                } else {
                    from = m+1;
                }
            }
        }
        return -1;
    }
}
