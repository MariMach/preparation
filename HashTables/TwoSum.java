import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 

Given an array of integers, return indices of the two numbers such
that they add up to a specific target.
Input: [2, 7, 11, 15] - target = 9
Output: [0, 1] (because 2 + 7 = 9)
Assume that each input has exactly one solution, and you may not use
the same element twice.

*/
public class TwoSum {

    // a + b = target
    // a = target -b
    // O(n)
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = target - arr[i];
            if (map.containsKey(a)) {
                return new int[] { map.get(a), i };
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4, 6, 7, 8, 9 }, 8)));
    }
}