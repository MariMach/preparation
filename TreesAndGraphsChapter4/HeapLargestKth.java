
public class HeapLargestKth {

    public static void largestKth(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException();
        }
        // max heap
        Heap heap = new Heap();
        for (int n : arr) {
            heap.insert(n);
        }
        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
        System.out.println(heap.theMax());
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 5, 3, 10, 1, 4, 2 };
        largestKth(numbers, 4);
    }
}