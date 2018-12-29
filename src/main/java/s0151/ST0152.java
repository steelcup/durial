package s0151;

import org.junit.jupiter.api.Test;

/*
152. Maximum Product Subarray
Medium

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 */
public class ST0152 {
    @Test
    public void test() {
        //int[] a = {2,3,-2,4};
       // int[] a = {-2, 0, -1};
        int[] a = {0, 2};
        System.out.println(maxProduct(a));
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int curMax = max, curMin = max;
        for (int n : nums) {
            int tempMax = curMax * n;
            int tempMin = curMin * n;
            curMax = Math.max(n, Math.max(curMin, curMax));
            curMin = Math.min(n, Math.max(curMin, curMax));
            max = Math.max(max, curMax);
        }
        return max;
    }
}
