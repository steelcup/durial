package s0000;
/*
46. Permutations
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 */

import java.util.*;

public class ST0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        helper(listList, nums, 0);
        return listList;
    }

    private void helper(List<List<Integer>> listList, int[] nums, int start) {
        if (start==nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            listList.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(listList, nums, start+1); //note.  it is start+1, not i+1 here
            swap(nums, i, start);
        }
    }

    private void swap(int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
