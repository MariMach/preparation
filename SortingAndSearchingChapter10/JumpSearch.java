public class JumpSearchs {

    // works only if the array is sorted
    // it is an improvement of binary search
    // we divide our array by blocks
    // mathematically Root of n is the ideal block size
    // we jump to the block where the item exists
    // we perform a linear search in that block

    // time complexity O(rootOf(n))
    // Best
    // average
    // worst

    // space complexity
    public static int jumpSearch(int target, int[] arr) {
        int blockSize = (int) Math.sqrt(arr.length);
        int start = 0, next = blockSize;
        while (start < arr.length && arr[next - 1] < target) {
            start = next;
            next = next + blockSize;
            if (next > arr.length) {
                next = arr.length;
            }
        }
        for (int i = start; i < next; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 5, 9, 20, 50 };
        Search_Jump search = new Search_Jump();
        System.out.println(search.jumpSearch(20, numbers));
    }
}