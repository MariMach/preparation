public class ArrayQueue {
    // Basic implementation using array
    // enqueue
    // dequeue
    // peek
    // isEmpty
    // isFull
    // Front Back pointers
    public class ArrayQueue {
        private int[] items;
        private int front = 0;
        private int back = 0;
        private int count = 0;

        public ArrayQueue(int capacity) {
            items = new int[capacity];
        }

        public void enqueue(int item) {
            items[back] = item;
            back++;
        }

        public void enqueue(int item) {
            if (count == items.length) {
                throw new IllegalStateException();
            }
            items[back] = item;
            // back++; // index out of bound solution circular array
            back = (back + 1) % items.length;
            count++;
        }

        public int dequeue() {
            int item = items[front];
            items[front] = 0;
            front = (front + 1) % items.length;
            count--;
            return item;
        }

        public int peek() {
            if (isEmpty())
                throw new IllegalStateException();

            return items[front];
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
}
