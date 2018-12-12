package s0051;
/*
79. Word Search
Medium

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class ST0079 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        char[]w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist2(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist2(char[][]a, int x, int y, char[]w, int wIdx) {
        if (wIdx == w.length) {
            return true;
        }
        if (x<0 || x >= a.length || y <0 || y >= a[0].length || a[x][y] != w[wIdx]) {
            return false;
        }
        char c = a[x][y];
        a[x][y] = 0; //mark to an impossible char
        //go 4 direction
        boolean b = exist2(a, x-1, y, w, wIdx+1) || exist2(a, x+1, y, w, wIdx+1) ||
                exist2(a, x, y-1, w, wIdx+1) || exist2(a, x, y+1, w, wIdx+1);
        a[x][y] = c;
        return b;
    }
}
