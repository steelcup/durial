package s0051;

import org.junit.jupiter.api.Test;

/*
64. Minimum Path Sum
Medium

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


 */
public class ST0064 {

    @Test
    public void test() {
        int[][] a = {{1,3,1},
                     {1,5,1},
                     {4,2,1}};
        System.out.println(minPathSum(a));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return findPath(grid);
    }

    public int findPath(int[][]a) {
        int rows = a.length, cols = a[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols;  j++) {
                if (j==0 && i==0) {
                   continue;
                }
                int up = i > 0 ?a[i-1][j] : Integer.MAX_VALUE;
                int left = j > 0?a[i][j-1] : Integer.MAX_VALUE;
                a[i][j] = a[i][j] + Math.min(up, left);
            }
        }
        return a[rows-1][cols-1];
    }

    /*
    public int findPath(int[][]a) {
        int rows = a.length, cols = a[0].length;
        int[][]c = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols;  j++) {
                if (j==0 && i==0) {
                    c[i][j] = a[0][0];
                } else {
                    int up = i > 0 ?c[i-1][j] : Integer.MAX_VALUE;
                    int left = j > 0?c[i][j-1] : Integer.MAX_VALUE;
                    c[i][j] = a[i][j] + Math.min(up, left);
                }
            }
        }
        return c[rows-1][cols-1];
    }
    */
}
