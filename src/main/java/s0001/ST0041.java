package s0001;

/*
41. First Missing Positive
Hard

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

 */
public class ST0041 {
    public int firstMissingPositive(int[] nums) {
        if (nums==null||nums.length==0) {
            return 1;
        }
        int idx;
        for (int i = 0; i < nums.length; i++) {
            idx = nums[i]-1;
            if (idx < 0 || idx >= nums.length) {
                continue;
            }
            if (idx!=i) {
                if (nums[i]==nums[idx]) {
                    nums[i] = 0;//current one is a dupe, so mark it
                } else {
                    int t = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = t;
                    i--; //keep the i, don't move forward
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
