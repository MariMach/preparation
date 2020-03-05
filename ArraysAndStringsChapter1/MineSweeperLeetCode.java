public class MineSweeperLeetCode {

    static class Solution {

        public static char[][] updateBoard(char[][] board, int[] click) {

            int i = click[0];
            int j = click[1];
            int n = board.length;
            int m = board[0].length;

            if (board[i][j] == 'M' || board[i][j] == 'X') {
                // game over
                board[i][j] = 'X';
                return board;
            }

            int num = 0;
            for (int r = i - 1; r <= i + 1; r++) {
                for (int c = j - 1; c <= j + 1; c++) {
                    if (r >= 0 && r < n && c < m && c >= 0 && board[r][c] == 'M') {
                        num++;
                    }
                }
            }

            if (num > 0) {
                char achar = (char) (num + '0');
                board[i][j] = achar;
                return board;
            }

            board[i][j] = 'B';
            for (int r = i - 1; r <= i + 1; r++) {
                for (int c = j - 1; c <= j + 1; c++) {
                    if (r >= 0 && r < n && c < m && c >= 0 && board[r][c] == 'E') {
                        updateBoard(board, new int[] { r, c });
                    }
                }
            }

            return board;
        }

    }

    public static void main(String args[]) {
        char[][] board = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' } };
        int[] click = { 3, 0 };
        char[][] arr = Solution.updateBoard(board, click);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[0].length - 1) {
                    System.out.print(" ");
                }
            }
            if (i != arr.length - 1) {
                System.out.println();
            }
        }
    }

}
