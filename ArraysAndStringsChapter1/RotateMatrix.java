/*
 * 
 * 
 * Rotate Matrix: Given an image represented by an N*N matrix, 
 * where each pixel in the image is 4 bytes write a method to rotate the image by 90 degrees.
 *  Can you do this in place ?
 * 
 */
public class RotateMatrix {

    // time complexity is O(nn)
    // space complexity is O(1)
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {

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
        rotate(matrix);
        System.out.println("matrix 1 : solution");
        print2DArray(matrix);

        System.out.println("matrix 2");
        print2DArray(matrix0);
        rotate(matrix0);
        System.out.println("matrix 2 : solution");
        print2DArray(matrix0);
    }
}