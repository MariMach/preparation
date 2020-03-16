import java.util.Arrays;

public class MergeSort {
    // look for in place merge sort

    // array of integers we want to sort it in ascending order
    // divide and conquer algorithm
    //

    // Time complexity stable
    // Best array already sorted O(n log(n)) logarithmic time
    // Average array not sorted O(n log(n)) logarithmic time
    // Worst array not sorted O(n log(n)) logarithmic time
    // model of computation Decision tree
    // divide and conquer algorithm

    // dividing o(log(n))
    // merging o(n)

    // Space Complexity best Worst O(n)

    public static void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // divide the array into half
        int middle = arr.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        int[] right = new int[arr.length - middle];
        for (int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }
        // it is a recursive solution
        // sort each half
        sort(left);
        sort(right);
        // merge the result
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int l = 0, r = 0, res = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[res] = left[l];
                l++;
                res++;
            } else {
                result[res] = right[r];
                r++;
                res++;
            }
        }
        while (l < left.length) {
            result[res] = left[l];
            l++;
            res++;
        }
        while (r < right.length) {
            result[res] = right[r];
            r++;
            res++;
        }
    }

    public static void merge(int[] sequence, int left, int middle, int right) {
        int[] result = new int[right - left];
        int i, j;
        int k = 0;

        for (i = left, j = middle; i < middle && j < right;) {
            if (sequence[i] < sequence[j]) {
                result[k++] = sequence[i];
                i++;
            } else {
                result[k++] = sequence[j];
                j++;
            }
        }

        while (i < middle) {
            result[k++] = sequence[i];
            i++;
        }

        while (j < right) {
            result[k++] = sequence[j];
            j++;
        }

        for (i = left; i < right; i++) {
            sequence[i] = result[i - left];
        }
    }

    public static void split(int[] sequence, int left, int right) {
        if (right - left < 2) {
            return;
        }
        int middle = (left + right) / 2;
        split(sequence, left, middle);
        split(sequence, middle, right);
        merge(sequence, left, middle, right);
    }

    public static int[] mergeSort(int[] sequence) {
        split(sequence, 0, sequence.length);
        return sequence;
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        // int[] numbers = {};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}