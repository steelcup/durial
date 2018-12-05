package s0000;

/*
18. 4Sum
Medium

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


 */

import java.util.*;

public class ST0018 {
    //https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
    //O(n^(k-1))
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        kSum(list, nums, 0, target, 4);
        return list;
    }

    private void kSum(List<List<Integer>> list, int[] nums, int start, int target, int k) {
        if (k==2) {
            sum2(list, nums, start, target);
            return;
        }
        for (int i = start; i < nums.length-k+1; i++) {
            if (i > start && nums[i]==nums[i-1]) {
                continue;
            }
            int curLen = list.size();
            kSum(list, nums, i+1, target-nums[i], k-1);
            for (int j = curLen; j < list.size();  j++) {
                list.get(j).add(nums[i]);
            }
        }
    }

    private void sum2(List<List<Integer>> list, int[] nums, int start, int target) {
        int i = start, j = nums.length-1, v;
        while (i < j) {
            v = nums[i] + nums[j];
            if (v == target) {
                list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                //only need to check when there is a match
                while (i < j && nums[i]==nums[i+1]) i++;
                while (i < j && nums[j]==nums[j-1]) j--;
                i++;
                j--;
            } else {
                if (v > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }
}
