import java.util.HashMap;
import java.util.Map;

public class MinimalIntervalLength {
    public static int intervalLength(int[] arr, int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        int n = arr.length;
        int l = Integer.MAX_VALUE;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == k) {
                return 1;
            }
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (sum[i] == k) {
                l = Math.min(l, i + 1);
            } else {
                for (int j = i; j < n; j++) {
                    if (sum[j] - sum[i] == k) {
                        l = Math.min(l, j - i);
                    }
                }
            }
        }
        return l;
    }

    /*
     * 
     * Complexity Analysis** Time complexity : O(n^2)
     * 
     * We need to consider every subarray possible.
     * 
     * Space complexity : O(1). Constant space is used.
     * 
     */

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // using a hashmap
    // Time Complexity O(n)
    // Space Complexity O(n)
    public static int subarraySumHashMap(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // using a hashmap
    // Time Complexity O(n)
    // Space Complexity O(n)
    public static int minIntervalHashMap(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            map.put(sum, i + 1);
            if (map.containsKey(sum - k)) {
                System.out.println("It might be the answer: " + (map.get(sum) - map.get(sum - k)));
                res = Math.min(res, map.get(sum) - map.get(sum - k));
            }
        }
        return res;
    }

    /*
     * Given a list of non-negative numbers and a target integer k, write a function
     * to check if the array has a continuous subarray of size at least 2 that sums
     * up to a multiple of k, that is, sums up to n*k where n is also an integer.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
     * continuous subarray of size 2 and sums up to 6. Example 2:
     * 
     * Input: [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4,
     * 7] is an continuous subarray of size 5 and sums up to 42.
     * 
     * 
     * Note:
     * 
     * The length of the array won't exceed 10,000. You may assume the sum of all
     * the numbers is in the range of a signed 32-bit integer.
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (j - i != 0) {
                    if (sum == k || (k != 0 && sum % k == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySumHashSet(int[] nums, int k) {
        int pre = 0, cur = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (k != 0) {
                cur = (pre + nums[i]) % k;
            } else {
                cur = pre + nums[i];
            }
            if (set.contains(cur)) {
                return true;
            }
            set.add(pre);
            pre = cur;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 8, 1, 2, 0, 2, 3, 4 };
        System.out.println(intervalLength(arr, 5));
        System.out.println(subarraySum(arr, 5));
        System.out.println(subarraySumHashMap(arr, 5));
        System.out.println("The answer is: " + minIntervalHashMap(arr, 29));
    }

}