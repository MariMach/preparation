import java.util.Set;
import java.util.HashSet;

/*

Given an array of integers, count the number of unique pairs of
integers that have difference k.
Input: [1, 7, 5, 9, 2, 12, 3] K=2
Output: 4
We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9). Note
that we only want the number of these pairs, not the pairs themselves.

*/

public class CountPairsWithDiff {

    // O(n)
    public static int CountPairsWithDiff(int[] arr, int k) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr) {
            if (set.contains(i + k)) {
                res++;
            }
            if (set.contains(i - k)) {
                res++;
            }
            set.remove(i);
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(CountPairsWithDiff(new int[] { 1, 7, 5, 9, 2, 12, 3 }, 2));
    }
}