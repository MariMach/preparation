import java.util.Arrays;

public class BubbleSort {

    // array of integers we want to sort it in ascending order
    // scan the array from left to right
    // if the right item is smaller that the left item we swap them
    // we are done with the first pass
    // we repeat that till the array is sorted

    // Time complexity
    // Best array already sorted O(n)
    // Average array not sorted O(n^2) quadratic time
    // Worst array not sorted O(n^2) quadratic time

    // Space Complexity Worst O(1)

    public static void sort(int[] array) {
        boolean sorted;
        for (int i = 0; i < array.length; i++) {
            sorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        // int[] numbers = {7, 7, 7, 7, 7, 7,7};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}