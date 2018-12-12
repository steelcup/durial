package s0051;
/*
90. Subsets II
Medium

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
import java.util.*;
public class ST0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        int lastSize = 1;
        int from;
        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            if (i > 0 && nums[i]==nums[i-1]) {//dup found
                from = size-lastSize;
            } else {
                from = 0;
            }
            for (int j = from; j < size; j++) {
                List<Integer> l = new ArrayList<>(list.get(j));
                l.add(nums[i]);
                list.add(l);
            }
            lastSize = size-from;
        }
        return list;
    }
}
