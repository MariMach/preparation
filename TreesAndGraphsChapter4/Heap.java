public class Heap {
    // using an array
    // left = parent * 2 + 1
    // right = parent * 2 + 2
    // parent = (index - 1) / 2
    // heap
    // int[]
    // insert(int) O(log n)
    // remove() O(log n)
    // a max heap O(1)
    private int[] items = new int[10];
    private int size;

    public void insert(int val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[size] = val;
        size++;
        bubbleUp();
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index, int parent) {
        int tmp = items[index];
        items[index] = items[parent];
        items[parent] = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(" ");
            System.out.print(items[i]);
        }
        System.out.println();
    }

    public int theMax() {
        return items[0];
    }

    // we always remove the root
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int root = items[0];
        items[0] = items[size - 1];
        size--;
        // if root < child => bubble it down
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            if (!hasLeftChild(index)) {
                return;
            }
            if (!hasRightChild(index)) {
                swap(index, leftChildIndex(index));
            }
            if (rightChild(index) > leftChild(index)) {
                swap(index, rightChildIndex(index));
            } else {
                swap(index, leftChildIndex(index));
            }
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return items[index] >= leftChild(index);

        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }
}