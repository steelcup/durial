package s0001;

/*
39. Combination Sum
Medium

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 */
import java.util.*;

public class ST0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        help(listList, new ArrayList<>(), candidates, 0, target);
        return listList;
    }

    private void help(List<List<Integer>> listList, List<Integer> buf, int[] nums, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            listList.add(new ArrayList<>(buf));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            buf.add(nums[i]);
            help(listList, buf, nums, i, target-nums[i]);
            buf.remove(buf.size()-1);
        }
    }
}
