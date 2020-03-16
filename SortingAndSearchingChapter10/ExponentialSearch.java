public class ExponentialSearch {

    // take an initial range an initial bound
    // look if the item exist by comparing the last item
    // if not we double the bound
    // if exist we perform a binary search in the range [bound/2, bound]
    // time complexity O(log(i))
    // i index of the element

    public static int binarySearchRec(int target, int[] arr, int left, int right) {
        if (right < left)
            return -1;
        int middle = (left + right) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] < target) {
            return binarySearchRec(target, arr, middle + 1, right);
        }
        return binarySearchRec(target, arr, left, middle - 1);
    }

    public static int exponentialSearch(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target) {
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearchRec(target, array, left, right);
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 5, 9, 20, 50 };
        System.out.println(exponentialSearch(numbers, 20));
    }
}