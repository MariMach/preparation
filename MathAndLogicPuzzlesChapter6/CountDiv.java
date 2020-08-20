/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
*/

public class CountDiv {
    public static int solution(int A, int B, int K) {
        /*
         * time complexity O(B-A) int res = 0; for (int i = A; i <= B; i++) { if ((i %
         * K) == 0) { res++; } } return res;
         */
        // space and time complexity O(1)
        return B / K - A / K + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2)); // 3 cuz 6 8 and 10 are divisible by 2
    }
}