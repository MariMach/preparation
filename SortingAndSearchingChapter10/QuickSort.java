import java.util.Arrays;

public class QuickSort {

    // array of integers we want to sort it in ascending order
    // In place
    // we choose a pivot (randomly, the first, the last , the middle one)
    // we rearrange the items till the pivot is in its place (the smaller items than
    // the pivot are in the left of the pivot and the greater are in its right)
    // choose another pivot continue in each partition
    // a partition with one item is sorted

    // Time complexity stable
    // Best array already sorted O(n log(n) ) logarithmic time
    // Average array not sorted O(n log(n)) logarithmic time
    // Worst array not sorted O(n^2) quadratic time

    // partitioning O(n)
    // number O(log(n)) worst O(n)

    // Space Complexity
    // Best O(log(n))
    // Worst O(n)

    public static void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // partition the array
        int boundary = partition(arr, start, end);
        // Sort left
        quicksort(arr, start, boundary - 1);
        // Sort right
        quicksort(arr, boundary + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                boundary++;
                swap(arr, i, boundary);
            }
        }
        return boundary;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        // int[] numbers = {};
        quicksort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}