import java.util.*;

public class IsOneArrayARotationOfAnother {

    public static boolean IsIt(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length) {
            return false;
        } else {
            int i = 0;
            int k = 0;
            int n = nums1.length;
            while (i < n) {
                if (nums1[k] == nums2[i]) {
                    for (int j = i + 1; j < n; j++) {
                        k++;
                        if (nums1[k] != nums2[j]) {
                            return false;
                        }
                    }
                    for (int j = 0; j < i; j++) {
                        k++;
                        if (nums1[k] != nums2[j]) {
                            return false;
                        }
                    }
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsIt(new int[] { 1, 3, 5, 9 }, new int[] { 9, 5, 1, 3 }));
    }
}
