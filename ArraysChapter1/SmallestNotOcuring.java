import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 

This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

*/

public class SmallestNotOcuring {

    public static int solution(int[] A) {
        int smallest = 1;
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        if (!set.isEmpty()) {
            while (set.contains(smallest)) {
                smallest++;
            }
        }
        return smallest;
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));
    }
}