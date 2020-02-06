/*
 * 
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 *  is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 *  Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, 
where births and deaths occur simultaneously.
 * 
 * 
 */
public class GameOfLife {

    // time complexity is O(nm)
    // space complexity is O(1)
    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ////////////////
                int regionSum = 0;
                for (int row = i - 1; row <= i + 1; row++) {
                    for (int col = j - 1; col <= j + 1; col++) {
                        if (existIJ(row, col, n, m)) {
                            if (board[row][col] == 1 || board[row][col] == 10 || board[row][col] == 11) {
                                regionSum++;
                            }
                        }
                    }
                }
                regionSum = regionSum - board[i][j];
                if (board[i][j] == 1) {
                    if (regionSum < 2 || regionSum > 3) {
                        // dies
                        board[i][j] = 10;
                    }
                    if (regionSum == 2 || regionSum == 3) {
                        // lives
                        board[i][j] = 11;
                    }
                }
                if (board[i][j] == 0 && regionSum == 3) {
                    // lives
                    board[i][j] = 20;
                }
                ///////////////
            }
        }

        System.out.println("during");
        print2DArray(board);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 20)
                    board[i][j] = 1;
                if (board[i][j] == 10)
                    board[i][j] = 0;
                if (board[i][j] == 11)
                    board[i][j] = 1;
            }
        }

    }

    public static boolean existIJ(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;
        return true;
    }

    public static void print2DArray(int[][] arr) {
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
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        System.out.println("before");
        print2DArray(board);
        gameOfLife(board);
        System.out.println("after");
        print2DArray(board);
    }
}