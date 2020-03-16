import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort {

    // array of integers we want to sort it in ascending order

    // Time complexity O(n+k)
    // stable
    // Best array already sorted O(n+k)
    // Average array not sorted O(n+k)
    // Worst array not sorted O(n+k)

    // populate counts o(n)
    // iterate count o(k)

    // Space Complexity best Worst O(k)

    /*
     * public void sort(int[] arr, int max) { int[] occur = new int[max+1]; for(int
     * i : arr) { occur[i]++; } int k = 0; for(int i = 0; i < occur.length; i++) {
     * for(int j = 0; j < occur[i]; j++) { arr[k] = i; k++; } } }
     */

    public static void sort(int[] nums) {
        Map<Integer, Integer> occurs = new HashMap<>();
        for (int i : nums) {
            occurs.put(i, occurs.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for (Map.Entry<Integer, Integer> i : occurs.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
            for (int j = 0; j < i.getValue(); j++) {
                nums[k] = i.getKey();
                k++;
            }
        }
    }

    public static int activityNotifications(int[] expenditure, int d) {
        int notifs = 0;
        int n = expenditure.length;
        int midd = (int) Math.floor(d / 2);
        int[] arr = new int[d];
        int[] occur = new int[201];
        for (int i = 0; i < d; i++) {
            occur[expenditure[i]]++;
            System.out.println(occur[expenditure[i]] + " " + expenditure[i]);
        }
        for (int i = 0; i + d < n; i++) {
            double median = 0;

            int k = 0;
            for (int r = 0; r < 201; r++) {
                if (occur[r] > 0) {
                    for (int j = 0; j < occur[r]; j++) {
                        arr[k] = r;
                        k++;
                    }
                }
                if (k >= d - 1)
                    break;
            }

            System.out.println(Arrays.toString(arr));

            if (d % 2 == 0) {
                median = (double) (arr[midd - 1] + arr[midd]) / 2;
            } else {
                median = arr[midd];
            }
            if (expenditure[i + d] >= 2 * median) {
                notifs++;
            }

            occur[expenditure[i]]--;
            occur[expenditure[i + d]]++;
            System.out.println(occur[expenditure[i]] + " " + expenditure[i]);
            System.out.println(occur[expenditure[i + d]] + " " + expenditure[i + d]);
        }
        return notifs;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 2, 3, 1, 4, 6, 2, 3 };

        // counting sort using a hashtable
        // turned to work only for positive numbers
        int[] test = { 6214, -2290, 2833, -7908 };

        // int[] numbers = {};
        // sorter.sort(test);
        sort(numbers);
        // System.out.println(Arrays.toString(test));

        System.out.println(activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
        // 10 20 30 40 50
        System.out.println(activityNotifications(new int[] { 10, 20, 30, 40, 50 }, 3));

    }
}
