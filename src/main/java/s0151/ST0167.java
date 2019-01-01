package s0151;
/*
167. Two Sum II - Input array is sorted
Easy

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class ST0167 {
    //because the array is SORTED, don't use map
    public int[] twoSum(int[] a, int target) {
        int[] ret = new int[]{-1, -1};
        if (a==null || a.length < 2) {
            return ret;
        }
        int i = 0, j = a.length-1, v;
        while(i < j) {
            v = a[i]+a[j];
            if (v==target) {
                ret[0] = i+1;
                ret[1] = j+1;
                return ret;
            } else if (v > target) {
                j--;
            } else {
                i++;
            }
        }
        return ret;
    }
}
