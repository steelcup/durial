package s0051;

/*
54. Spiral Matrix
Medium

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
import java.util.*;

public class ST0054 {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> list = new ArrayList<>();
        if (m == null || m.length == 0) {
            return list;
        }
        int x = 0, y = 0, numRows = m.length, numCols = m[0].length;
        int direction = 0; //0: top goes right,  1: right goes down, 2:  bottom goes left,  3: left goes up
        while (numRows != 0 && numCols != 0) {
            switch(direction) {
                case 0:
                    for (int i = y; i < y+numCols; i++) {
                        list.add(m[x][i]);
                    }
                    x++;
                    numRows--;
                    break;
                case 1:
                    for (int i = x; i < x+numRows; i++) {
                        list.add(m[i][y+numCols-1]);
                    }
                    numCols--;
                    break;
                case 2:
                    for (int i = y+numCols-1; i >= y; i--) {
                        list.add(m[x+numRows-1][i]);
                    }
                    numRows--;
                    break;
                case 3:
                    for (int i = x+numRows-1; i >= x; i--) {
                        list.add(m[i][y]);
                    }
                    numCols--;
                    y++;
                    break;
                default:
                    break;
            }
            direction = (direction+1)%4;
        }
        return list;
    }
}
