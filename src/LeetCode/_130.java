package LeetCode;

/**
 * @author polarisChen
 * @create 2021/7/21 6:05 下午
 */
public class _130 {
    public void solve(char[][] board) {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j]=='O') {
                    dfs(board,i,j);
                }
            }
        }
    }

    public boolean dfs(char[][] board,int i,int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j]=='O') {
            board[i][j]='X';
            boolean flag=dfs(board, i + 1, j) && dfs(board, i - 1, j)
                    && dfs(board, i, j + 1) && dfs(board, i , j - 1);
            if (!flag) board[i][j]='O';
        }
        return true;
    }
}
