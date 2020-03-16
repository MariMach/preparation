import java.util.Arrays;

public class InsertionSort {

    // array of integers we want to sort it in ascending order
    // insert an item in the right position
    // we look to all the items before the item before inserting in the righjt
    // position
    // we store the item to a variable
    // we found the right position we shift and insert our item

    // Time complexity
    // Best array already sorted O(n) quadratic time
    // Average array not sorted O(n^2) quadratic time
    // Worst array not sorted O(n^2) quadratic time

    // Space Complexity Worst O(1)

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int t = i - 1;
            while (t >= 0 && array[t] > current) {
                array[t + 1] = array[t];
                t--;
            }
            array[t + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}