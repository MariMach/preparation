
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    // k buckets
    // each bucket hold a linked list of array items
    // each linked list is sorted using another sorting algorithm
    // Fewer buckets O(n^2) time complexity
    // More buckets O(n) time complexity + space complexity

    // space complexity O(n + k)

    // time complexity
    // best O(n + k)
    // average O(n + k)
    // worst O(n^2)

    // distribution best O(n) worst O(n)
    // iterating buckets best O(k) worst O(k)
    // sorting best O(1) worst O(n^2)
    // total best O(n+k) worst O(n^2)

    public static void sort(int[] arr, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int item : arr) {
            buckets.get(item / numberOfBuckets).add(item);
        }
        int counter = 0;
        for (List bucket : buckets) {
            Collections.sort(bucket);
            for (Object i : bucket) {
                arr[counter] = (int) i;
                counter++;
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
        sort(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}