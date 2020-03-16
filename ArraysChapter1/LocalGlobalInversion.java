public class LocalGlobalInversion {
    public static boolean isIdealPermutation(int[] A) {
        int global = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    global++;
                }
            }
        }
        int local = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                local++;
            }

        }
        return local == global;
    }

    public static void main(String args[]) {
        System.out.println(isIdealPermutation(new int[] { 1, 2, 3, 5, 4 }));
    }
}