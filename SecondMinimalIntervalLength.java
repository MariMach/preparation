public class SecondMinimalIntervalLength {

    public static int intervalLength2(int[] arr, int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        int n = arr.length;
        int l = Integer.MAX_VALUE;

        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 3, 4, 6, 3, 1, 4, 2, 8 };
        System.out.println(intervalLength2(arr, 5));
    }

}