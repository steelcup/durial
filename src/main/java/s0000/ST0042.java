package s0000;

/*
42. Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6


 */
public class ST0042 {
    public int trap(int[] height) {
        if (height==null || height.length < 2) {
            return 0;
        }
        //https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
        int count = 0;
        int i=0, j=height.length-1;
        int leftMax = height[i], rightMax = height[j];
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                count += leftMax-height[i++];
            } else {
                count += rightMax-height[j--];
            }
        }
        return count;
    }
}
