/*
 * 
 * 
 * Zero Matrix: Write an algorithm such that if an element in an 
 * MxN matrix is 0, its entire row and column are set to 0.
 * do it in-place
 * 
 */
public class ZeroMatrix {

    // time complexity is O(mn)
    // space complexity is O(1)
    public static void toZeroMatrix(int[][] matrix) {
        // 2 1 0 2
        // 0 4 0 2
        // 5 3 1 4
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = false, row0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
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

        int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] matrix0 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        System.out.println("matrix 1");
        print2DArray(matrix);
        toZeroMatrix(matrix);
        System.out.println("matrix 1 : solution");
        print2DArray(matrix);

        System.out.println("matrix 2");
        print2DArray(matrix0);
        toZeroMatrix(matrix0);
        System.out.println("matrix 2 : solution");
        print2DArray(matrix0);
    }
}