package s0051;
/*
77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
import java.util.*;

public class ST0077 {
    //if n = 4, k=2 means get 2 number from array [1,2,3,4] ,and no duplicate
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        combine2(listList, new ArrayList<>(), 1, n, k);
        return listList;
    }

    public void combine2(List<List<Integer>> listList, List<Integer> buf, int from, int n, int k) {
        if (buf.size()==k) {
            listList.add(new ArrayList<>(buf));
        }
        for (int i = from; i <= n; i++) {
            buf.add(i);
            combine2(listList, buf, i+1, n, k);
            buf.remove(buf.size()-1);
        }
    }
}
