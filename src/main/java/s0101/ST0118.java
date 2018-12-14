package s0101;
/*
118. Pascal's Triangle
Easy

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

import java.util.*;

public class ST0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        if (numRows == 0) {
            return listList;
        }
        List<Integer> pre = Arrays.asList(1);
        listList.add(pre);
        for (int i = 1; i < numRows; i++) {
            int len = i+1;
            List<Integer> list = new ArrayList<>(len);
            list.add(1);
            for (int j = 1; j < len-1; j++) {
                list.add(pre.get(j)+pre.get(j-1));
            }
            list.add(1);
            listList.add(list);
            pre = list;
        }
        return listList;
    }
}
