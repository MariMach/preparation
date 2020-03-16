import java.util.Scanner;

public class SurroundedRegionsXO {

    // runtime error
    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int r = board.length;
        int c = board[0].length;
        int[][] visited = new int[r][c];

        for (int row = 1; row < r; row++) {
            for (int col = 1; col < c; col++) {

                if (board[row][col] == 'O') {
                    if (findRegion(board, row, col, visited) == true)
                        board[row][col] = 'X';
                }
            }
        }
    }

    private static boolean findRegion(char[][] board, int row, int col, int[][] visited) {
        /*
         * Put boundary checks here (at top of recursive call), instead of before doing
         * recursive call
         */
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board == null
                || board[row][col] == 'X' || visited[row][col] == 1) {
            return true;
        }
        if (row == 0 || row == board.length - 1 || col == 0 || col == board[row].length - 1) {
            return false;
        }
        visited[row][col] = 1;
        return findRegion(board, row - 1, col, visited) && findRegion(board, row + 1, col, visited)
                && findRegion(board, row, col - 1, visited) && findRegion(board, row, col + 1, visited);
    }

    public static void main(String args[]) {
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X', 'O' },
                { 'X', 'X', 'O', 'X', 'X' }, { 'X', 'O', 'X', 'X', 'O' } };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}