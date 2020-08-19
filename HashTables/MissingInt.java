import java.util.HashSet;
import java.util.Set;

/*
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)].
 */

public class MissingInt {
    public static int solution(int[] A) {
        int missing = 1;
        if (A == null) {
            return 1;
        }
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[] { 1, 2, 4, 5 }));
        System.out.println(solution(null));
        System.out.println(solution(new int[] { 2 }));

    }
}