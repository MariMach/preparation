public class ClosedIsland {

    public static void solve(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int r = board.length;
        int c = board[0].length;

        for (int col = 0; col < c; col++) {
            if (board[0][col] == 0) {
                findRegion(board, 0, col);
            }
        }
        for (int col = 0; col < c; col++) {
            if (board[r - 1][col] == 0) {
                findRegion(board, r - 1, col);
            }
        }
        for (int row = 0; row < r; row++) {
            if (board[row][0] == 0) {
                findRegion(board, row, 0);
            }
        }
        for (int row = 0; row < r; row++) {
            if (board[row][c - 1] == 0) {
                findRegion(board, row, c - 1);
            }
        }
        int connected = 0;
        for (int row = 1; row < r - 1; row++) {
            for (int col = 1; col < c - 1; col++) {
                if (board[row][col] == 0) {
                    connected++;
                    findIsland(board, row, col);
                }
            }
        }

    }

    private static void findIsland(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        /*
         * Put boundary checks here (at top of recursive call), instead of before doing
         * recursive call
         */
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid == null || grid[row][col] != 0) {
            return;
        }

        grid[row][col] = 1; // we alter the original matrix here

        findIsland(grid, row - 1, col);
        findIsland(grid, row + 1, col);
        findIsland(grid, row, col - 1);
        findIsland(grid, row, col + 1);

    }

    private static void findRegion(int[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board == null
                || board[row][col] != 0) {
            return;
        }
        board[row][col] = 1;
        findRegion(board, row - 1, col);
        findRegion(board, row + 1, col);
        findRegion(board, row, col - 1);
        findRegion(board, row, col + 1);
    }

}
