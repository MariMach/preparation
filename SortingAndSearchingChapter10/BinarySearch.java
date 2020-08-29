public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key < a[mid]) {
                right = mid - 1;
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

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

    public static int binarySearchItera(int target, int[] arr) {
        int left = 0, right = arr.length - 1, middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(binarySearch(a, 5));

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(binarySearchRec(9, numbers, 0, numbers.length - 1));
        System.out.println(binarySearchItera(9, numbers));
    }
}
