package s0000;

/*
15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


 */

import java.util.*;

public class ST0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        //O(n^2) solution
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //fix one index i, and use two pointers j, k to find the reminder target so have i,j,k
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i]==nums[i-1]) {//avoid dupe
                continue;
            }
            int target = 0-nums[i];
            int j = i+1, k = nums.length-1;
            while (j < k) {
                int v = nums[j]+nums[k];
                if (v==target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j]==nums[j-1]) j++; //avoid dupe
                    while (j < k && nums[k]==nums[k+1]) k--;
                    continue;
                }
                if (v > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}
