/*
 * 
 * 
 * Rotate Matrix: Given an image represented by an N*N matrix, 
 * where each pixel in the image is 4 bytes write a method to rotate the image by 90 degrees.
 *  Can you do this in place ?
 * 
 */
public class RotateMatrix {

    // time complexity is O(n*n)
    // space complexity is O(1)
    public static void rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
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

        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("matrix 1");
        print2DArray(matrix);
        rotate90Clockwise(matrix);
        System.out.println("matrix 1 : solution");
        print2DArray(matrix);

    }
}