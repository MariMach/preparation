public class Array {
    private int count = 0;
    private int[] items;

    public Array(int length) {
        items = new int[length];
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

}