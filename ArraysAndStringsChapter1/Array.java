public class Array {
    private int count = 0;
    private int[] items;

    public Array(int length) {
        items = new int[length];
    }

    public int size() {
        return count;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int a) {
        // if the array is full we need to resize it
        if (items.length == count) {
            // create a new array twice the size
            int[] newItems = new int[count * 2];
            // copy all the existing items into the new array
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // set items to the new array
            items = newItems;
        }
        // add the new item at the end
        items[count] = a;
        count++;
    }

    public void removeAt(int index) {
        // validate the index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // shift items to the left to fill the hole
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        // if we find the item return the index
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        // else return -1
        return -1;
    }

    // O(n)
    /*
     * 1- Extend the Array class and add a new method to return the largest number.
     * What is the runtime complexity of this method? Solution: Array.max()
     */
    public int max() {
        int max = items[0];
        // if we find the max return it
        for (int i = 0; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public int min() {
        int min = items[0];
        // if we find the max return it
        for (int i = 0; i < count; i++) {
            if (items[i] < min) {
                min = items[i];
            }
        }
        return min;
    }

    /*
     * 2- Extend the Array class and add a method to return the common items in this
     * array and another array. Solution: Array.intersect()
     */
    public int[] intersect(int[] arr) {
        int[] res = new int[count];
        // to complete
        return res;
    }

    /*
     * 3- Extend the Array class and add a method to reverse the array. For example,
     * if the array includes [1, 2, 3, 4], after reversing and printing it, we
     * should see [4, 3, 2, 1]. Solution: Array.reverse()
     */
    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            int temp = items[i];
            items[i] = items[count - i - 1];
            items[count - i - 1] = temp;
        }
    }

    /*
     * 4- Extend the Array class and add a new method to insert an item at a given
     * index: public void insertAt(int item, int index) Solution: Array.insertAt()
     */
    public void insertAt(int item, int index) {
        // validate the index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // if the array is full we need to resize it
        if (items.length == count) {
            // create a new array twice the size
            int[] newItems = new int[count * 2];
            // copy all the existing items into the new array
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // set items to the new array
            items = newItems;
        }
        // shift items to the left to fill the hole
        for (int i = index; i < count; i++) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }
}
