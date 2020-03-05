
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Transpose {
    public static int[][] rotateOutOfPlace(int[][] nums, int n, int m) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = nums[j][i];
            }
        }
        return res;
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
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = rotateOutOfPlace(arr, n, m);
        print2DArray(res);

    }
}
