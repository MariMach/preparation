public class LarrysArray {
    /*
     * One Fact: A rotation does not change the parity of the number of inversions.
     * 
     * That is because, the number of inversions can be decomposed into these three
     * parts:
     * 
     * The inversions among the three numbers involved in the rotation. The
     * inversions among the numbers not involved in the rotation. The inversions
     * between the three numbers and the other numbers. For part 2 and 3, the number
     * of inversions are unchanged. For part 1, the number of inversions are changed
     * by 2 % 2 = 0. (Since 1 number is moved to the front of other 2 numbers,
     * actually, if you move 1 number to the front of n numbers, the number of
     * inversions will be changed by n % 2).
     * 
     * Two Directions:
     * 
     * If the array is sortable, then the initial number of inversions is even. If
     * the initial number of inversions is even, then the array is sortable.
     * Direction 1 is obvious, since the final position has a inversion with number
     * 0, and rotations does not change the parity of inversions. So in the
     * beginning, the number of inversions must be even.
     * 
     * Direction 2 can be proved by construction. We can do the following to sort
     * the array like bubble sort. We first do rotations of position 1 to n to put 1
     * in position 1, then do rotations of position 2 to n to put 2 in position 2.
     * By doing this, we can do rotations to put n-3 in position n-3. Then there are
     * 2 numebrs left, and we have no more numbers to do rotations. So are the last
     * 2 numbers sorted already? The answer is yes, since we have the assumption
     * that the number of initial inversions is even.
     * 
     * So far, we have proved the correctness of this claim.
     * 
     * 
     */
    // Sorting possible using size 3 subarray rotation
    public static String larrysArray(int[] A) {
        int n = A.length;
        // count inversions
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        if (count % 2 == 0) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String args[]) {
        System.out.println(larrysArray(new int[] { 3, 1, 2 })); // yes
        System.out.println(larrysArray(new int[] { 1, 3, 4, 2 })); // yes
        System.out.println(larrysArray(new int[] { 1, 2, 3, 5, 4 })); // no
        System.out.println(larrysArray(new int[] { 1, 6, 5, 2, 4, 3 })); // yes
    }
}