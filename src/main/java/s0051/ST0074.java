package s0051;
/*
74. Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false


 */
public class ST0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n-1, v;
        while (y >= 0 && x < m) {
            v = matrix[x][y];
            if (v==target) {
                return true;
            }
            if (target < v) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
