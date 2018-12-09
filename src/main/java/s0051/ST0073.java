package s0051;
/*
73. Set Matrix Zeroes
Medium

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?


 */
public class ST0073 {
    public void setZeroes(int[][] m) {
        if (m == null || m[0].length == 0) {
            return;
        }
        //check if first row has any zero
        boolean firstRowZero = false;
        for (int i : m[0]) {
            if (i == 0) {
                firstRowZero = true;
                break;
            }
        }
        //check if first col has any zero
        boolean firstColZero = false;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        //check if any zero.  mark on the first row and col as zero
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }
        //check first row and col, and mark the whole row or col
        //don't check the (0,0)
        for (int i = 1; i < m[0].length; i++) {
            if (m[0][i] == 0) {
                for (int j = 1; j < m.length; j++) {
                    m[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] == 0) {
                for (int j = 1; j < m[i].length; j++) {
                    m[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < m[0].length; i++) {
                m[0][i] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m.length; i++) {
                m[i][0] = 0;
            }
        }
    }
}
