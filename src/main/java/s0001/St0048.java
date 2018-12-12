package s0001;

/*
48. Rotate Image
Medium

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


 */
public class St0048 {
    // 顺时针旋转
    // 首先上下翻转，然后按对称元素交换即可
    // 1 2 3       7 8 9       7 4 1
    // 4 5 6  =>   4 5 6  =>   8 5 2
    // 7 8 9       1 2 3       9 6 3
    // 反时针旋转
    // 首先左右翻转，接着按对称元素交换即可
    // 1 2 3       3 2 1       3 6 9
    // 4 5 6  =>   6 5 4  =>   2 5 8
    // 7 8 9       9 8 7       1 4 7
    public void rotate(int[][] m) {
        if (m == null || m.length==0) {
            return;
        }
        int rows = m.length, cols = m[0].length;
        for (int j = 0; j < cols; j++) {
            int x=0, y=rows-1;
            while (x < y) {
                int t = m[x][j];
                m[x++][j] = m[y][j];
                m[y--][j] = t;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
    }
}
