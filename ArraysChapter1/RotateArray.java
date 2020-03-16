import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[k];
        int start = nums.length - k;
        int n = nums.length;
        // store the k last numbers
        for (int i = start, j = 0; i < n && j < k; i++, j++) {
            tmp[j] = nums[i];
        }
        // shifting
        for (int i = start - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        // put the k numbers in the front
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotate(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
