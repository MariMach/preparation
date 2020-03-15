import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        // max heap
        Heap heap = new Heap();
        for (int n : arr) {
            heap.insert(n);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.remove();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 5, 3, 10, 1, 4, 2 };
        heapSort(numbers);
    }
}