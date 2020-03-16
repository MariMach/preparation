public class SearchTernary {

    // binary search is better than ternary search

    // works only if the array is sorted
    // we divide the array by three partitions
    // partitionSize = (right-left)/3
    // mid1 = left + partitionSize
    // mid2 = right - partitionSize

    // time complexity O(log3(n))
    //

    public static int searchTernary(int target, int arr[], int left, int right) {
        if (left > right) {
            return -1;
        }

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (arr[mid1] == target) {
            return mid1;
        }
        if (arr[mid2] == target) {
            return mid2;
        }
        if (target < arr[mid1]) {
            return searchTernary(target, arr, left, mid1 - 1);
        }
        if (target > arr[mid2]) {
            return searchTernary(target, arr, mid2 + 1, right);
        }
        // if(target > arr[mid1] && target < arr[mid2] ) {
        return searchTernary(target, arr, mid1 + 1, mid2 - 1);
        // }
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Search_Ternary search = new Search_Ternary();
        System.out.println(search.searchTernary(9, numbers, 0, numbers.length - 1));
    }
}