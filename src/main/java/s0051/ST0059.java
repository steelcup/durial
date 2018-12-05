package s0051;

/*
59. Spiral Matrix II
Medium

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


 */
public class ST0059 {
    public int[][] generateMatrix(int n) {
        int[][]a = new int[n][n];
        int x=0, y=0, rows=n, cols=n;
        int direction = 0;
        int num = 1;
        while(rows>0 && cols > 0) {
            switch(direction) {
                case 0: //up, left to right
                    for (int i = y; i < y+cols; i++) {
                        a[x][i] = num++;
                    }
                    x++;
                    rows--;
                    break;
                case 1: //right, up to down
                    for (int i = x; i < x+rows; i++) {
                        a[i][y+cols-1] = num++;
                    }
                    cols--;
                    break;
                case 2: //bottom, right to left
                    for (int i = y+cols-1; i >=y; i--) {
                        a[x+rows-1][i] = num++;
                    }
                    rows--;
                    break;
                case 3: //left, bottom to tp
                    for (int i = x+rows-1; i >= x; i--) {
                        a[i][y] = num++;
                    }
                    y++;
                    cols--;
                    break;
                default:
                    break;
            }
            direction = (direction+1)%4;
        }
        return a;
    }
}
