import java.util.Arrays;

public class LinearSearch {

    // very slow

    // time complexity
    // Best O(1)
    // O(n/2)
    // Worst O(n)

    // space complexity O(1)
    public static int linearSearch(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        Search_Linear search = new Search_Linear();
        System.out.println(search.linearSearch(3, numbers));
    }
}