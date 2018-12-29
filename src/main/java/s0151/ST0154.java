package s0151;
/*
154. Find Minimum in Rotated Sorted Array II
Hard

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0
 */
public class ST0154 {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length-1, m=0;
        while (i <= j) {
            m = i + (j-i)/2;
            //always compare to the end
            if (nums[m] < nums[j]) {
                j = m;
            } else if (nums[m] > nums[j]) {
                i = m + 1;
            } else {
                j--;
            }
        }
        return nums[m];
    }
}
