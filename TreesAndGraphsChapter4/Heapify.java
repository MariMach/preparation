import java.util.Arrays;

public class Heapify {

    // arr.length 7
    // the index of the last parent is (7/2)-1=2

    public static void heapify(int[] arr) {
        int lastParent = arr.length / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            heapify(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int index, int parent) {
        int tmp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = tmp;
    }

    private static void heapify(int[] arr, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < arr.length && arr[leftIndex] > arr[index]) {
            System.out.println(arr[leftIndex] + " left " + arr[index]);
            swap(arr, leftIndex, index);
        }
        if (rightIndex < arr.length && arr[rightIndex] > arr[index]) {
            System.out.println(arr[rightIndex] + " right " + arr[index]);
            swap(arr, rightIndex, index);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 1, 2 };
        heapify(arr);
    }
}