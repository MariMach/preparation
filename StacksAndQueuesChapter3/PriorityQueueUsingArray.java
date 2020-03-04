public class PriorityQueueUsingArray {

    // ProiorityQueue
    // items are inserted in ascending order
    // [1, 3, 5, 7]
    // insert(2)
    // [1, 2, 3, 5, 7]

    private int[] items = new int[5];
    private int count = 0;

    public void add(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        // shifting items
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int shiftItemsToInsert(int item) {
        int i = 0;
        for (i = count - 1; i >= 0; i++) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (count == 0) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}