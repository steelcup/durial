package s0000;

/*
47. Permutations II
Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


 */

import java.util.*;

public class ST0047 {
    public List<List<Integer>> permuteUnique(int[] a) {
        List<List<Integer>> listList = new ArrayList<>();
        if (a != null && a.length > 0) {
            //Arrays.sort(a);
            combinePermuteUnique(a, 0, listList);
        }
        return listList;
    }

    private void combinePermuteUnique(int[]a, int from, List<List<Integer>> listList) {
        if (from == a.length) {
            List<Integer> list = new ArrayList<>();
            for (int i:a) {
                list.add(i);
            }
            listList.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = from; i < a.length; i++) {
            if (!set.add(a[i])) {
                //sort and checking previous wouldn't work because we swap
                continue;
            }
            swap(a, from, i);
            combinePermuteUnique(a, from+1, listList);
            swap(a, from, i);
        }
    }

    private void swap(int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
