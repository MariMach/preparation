import java.util.ArrayList;
import java.util.List;

public class CommonElementsInTwoSortedArrays {

    static class Solution {

        public static List<Integer> CommonElements(int[] nums1, int[] nums2) {
            ArrayList<Integer> CommonElements = new ArrayList<>();
            int i1 = 0, i2 = 0;
            while (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] == nums2[i2]) {
                    CommonElements.add(nums1[i1]);
                    i1++;
                    i2++;
                } else if (nums1[i1] > nums2[i2]) {
                    i2++;
                } else {
                    i1++;
                }
            }
            return CommonElements;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.CommonElements(new int[] { 1, 3, 5, 8 }, new int[] { 1, 3, 4, 4, 5, 8, 9 }));
    }
}
