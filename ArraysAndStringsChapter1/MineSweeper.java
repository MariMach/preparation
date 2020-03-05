import java.util.Arrays;

public class MineSweeper {

    static class solution {
        // Implement your solution below.
        public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
            int[][] field = new int[numRows][numCols];
            for (int[] bomb : bombs) {
                int rowIndex = bomb[0];
                int colIndex = bomb[1];
                field[rowIndex][colIndex] = -1;
                for (int i = rowIndex - 1; i < rowIndex + 2; i++) {
                    for (int j = colIndex - 1; j < colIndex + 2; j++) {
                        if (isValid(field, i, j)) {
                            field[i][j] += 1;
                        }
                    }
                }
            }
            return field;
        }

        public static boolean isValid(int[][] nums, int i, int j) {
            if (0 <= i && i < nums.length && 0 <= j && j < nums[0].length && nums[i][j] != -1) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] bombs3 = { { 1, 1 }, { 1, 2 }, { 2, 2 }, { 4, 3 } };
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        // [1, -1, -1, 2, 0],
        // [1, 3, -1, 2, 0],
        // [0, 1, 2, 2, 1],
        // [0, 0, 1, -1, 1]]
        int[][] arr = solution.mineSweeper(bombs3, 5, 5);
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
