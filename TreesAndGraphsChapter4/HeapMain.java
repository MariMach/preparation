public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.print();
        // O(1)
        System.out.println(heap.theMax());
        heap.remove();
        heap.print();

    }
}