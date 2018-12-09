package s0051;
/*
78. Subsets
Medium

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import org.junit.jupiter.api.Test;

import java.util.*;

public class ST0078 {
    @Test
    public void test() {
        int[]nums = {1,2,3};
        System.out.println(subsets(nums).toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        /*
        listList.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = listList.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(listList.get(j));
                list.add(nums[i]);
                listList.add(list);
            }
        }
        */
        backTrack(listList, new ArrayList<>(), nums, 0);
        return listList;
    }

    private void backTrack(List<List<Integer>>listList, List<Integer> buf, int[]nums, int start) {
        listList.add(new ArrayList<>(buf));
        for (int i = start; i < nums.length; i++) {
            buf.add(nums[i]);
            backTrack(listList, buf, nums, i+1);
            buf.remove(buf.size()-1);
        }
    }
}
