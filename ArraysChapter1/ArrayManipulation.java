import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ArrayManipulation {

    // O(n + m) time complexity
    // O(n) space complexity
    public static long arrayManipulation(int n, int[][] queries) {
        int m = queries.length;
        long max = 0;
        long sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < m; i++) {
            a[queries[i][0] - 1] = a[queries[i][0] - 1] + queries[i][2];
            if (queries[i][1] < n) {
                a[queries[i][1]] = a[queries[i][1]] - queries[i][2];
            }
        }
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 }, { 4, 7, 5 } };
        int[][] arr1 = new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
        System.out.println(arrayManipulation(10, arr));
        System.out.println(arrayManipulation(10, arr1));
    }
}