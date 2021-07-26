package 剑指offer;
/*
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
* */
//深搜
public class offer_12_矩阵中的路径_important {
    static class Solution {
        //速度比较快的方法
        public boolean exist1(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, words, i, j, 0)) {return true;}
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if(k == word.length - 1) return true;
            char tmp = board[i][j];
            board[i][j] = '/';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = tmp;
            return res;
        }
        //我的方法
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            //遍历所有点
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    if (aux_exist(i, j, used, board, words, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        //二维数组必须这样才能深层克隆
        //https://blog.csdn.net/weixin_40758608/article/details/109480043
        public boolean[][] clone(boolean[][] x) {
            boolean[][] y = new boolean[x.length][x[0].length];
            for (int i = 0; i < x.length; i++) {
                y[i] = x[i].clone();
            }
            return y;
        }

        //辅助方法的核心就是递归,如果当前位置的字符符合,那就继续看他上下左右四个方向,如果不符合就返回false,如果刚好到了尾巴那就返回true
        //核心就是每次尝试都要用一个新的used1数组,不然会污染一些正确的路
        public boolean aux_exist(int i, int j, boolean[][] used, char[][] board, char[] words, int num) {
            if (used[i][j] || words[num] != board[i][j]) {
                return false;
            }
            used[i][j] = true;
            if (num == words.length - 1) {
                return true;
            }
            boolean flag;

            if (i + 1 < board.length && !used[i + 1][j]) {
                boolean[][] used1 = clone(used);

                flag = aux_exist(i + 1, j, used1, board, words, num + 1);
                if (flag) {
                    return true;
                }
            }
            if (j + 1 < board[0].length && !used[i][j + 1]) {
                boolean[][] used1 = clone(used);
                flag = aux_exist(i, j + 1, used1, board, words, num + 1);
                if (flag) {
                    return true;
                }

            }

            if (j > 0 && !used[i][j - 1]) {
                boolean[][] used1 = clone(used);

                flag = aux_exist(i, j - 1, used1, board, words, num + 1);
                if (flag) {
                    return true;
                }
            }



            if (i > 0 && !used[i - 1][j]) {
                boolean[][] used1 = clone(used);
                flag = aux_exist(i - 1, j, used1, board, words, num + 1);
                if (flag) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            char[][] x = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
            System.out.println(s.exist(x, "ABCESEEEFS"));
        }
    }
}
