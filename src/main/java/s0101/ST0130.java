package s0101;
/*
130. Surrounded Regions
Medium

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class ST0130 {int m=0, n=0;
    public void solve(char[][] a) {
        if (a == null || a.length == 0) {
            return;
        }
        m = a.length;
        n = a[0].length;
        for (int i = 0; i < m; i++) {
            expand(a, i, 0);
            expand(a, i, n-1);
        }

        for (int i = 0; i < n; i++) {
            expand(a, 0, i);
            expand(a, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == '*') {
                    a[i][j] = 'O';
                }
            }
        }
    }

    private void expand(char[][] a, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >=n || a[x][y] != 'O') {
            return;
        }
        a[x][y] = '*';
        expand(a, x-1, y);
        expand(a, x+1, y);
        expand(a, x, y-1);
        expand(a, x, y+1);

    }
}
