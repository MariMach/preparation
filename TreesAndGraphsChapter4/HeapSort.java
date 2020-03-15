public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = new int[] { 5, 3, 10, 1, 4, 2 };
        Heap heap = new Heap();
        for (int n : numbers) {
            heap.insert(n);
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }

    }
}