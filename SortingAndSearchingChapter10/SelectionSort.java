import java.util.Arrays;

public class SelectionSort {

    // array of integers we want to sort it in ascending order
    // scan the array from left to right
    // find the min item and move it in its position
    // the array has a sorted part ana unsorted part
    // we continue searching for the min in the unsorted part and move it to the
    // right place

    // Time complexity
    // Best array already sorted O(n^2) quadratic time
    // Average array not sorted O(n^2) quadratic time
    // Worst array not sorted O(n^2) quadratic time

    // Space Complexity Worst O(1)

    public static void sort(int[] array) {
        for (int t = 0; t < array.length; t++) {
            int min = t;
            for (int i = t + 1; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            swap(array, t, min);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}