package s0000;

/*
40. Combination Sum II
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]


 */

import java.util.*;

public class ST0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(candidates);
        comhelp(listList, new ArrayList<>(), candidates, 0, target);
        return listList;
    }

    private void comhelp(List<List<Integer>> listList, List<Integer> buff, int[]a, int start, int target) {
        if (target<0) {
            return;
        }
        if (target==0) {
            listList.add(new ArrayList<>(buff));
            return;
        }
        for (int i = start; i < a.length; i++) {
            if (i > start && a[i]==a[i-1]) {
                continue;
            }
            buff.add(a[i]);
            comhelp(listList, buff, a, i+1, target-a[i]);
            buff.remove(buff.size()-1);
        }
    }
}
