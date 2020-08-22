import java.util.Arrays;

/*
A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
*/
public class GenomicRangeQuery {

    // Time Complexity O(M*N)
    // Space Complexity O(M+N)
    public static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] res = new int[M];
        int[] val = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = getValue(S.charAt(i));
        }
        for (int i = 0; i < M; i++) {
            if (P[i] == Q[i]) {
                res[i] = val[P[i]];
            } else {
                res[i] = GetMin(val, P[i], Q[i]);
            }
        }
        return res;
    }

    public static int GetMin(int[] arr, int start, int end) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static int getValue(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'G') {
            return 3;
        }
        return 4;
    }

    // Time Complexity O(M+N)
    // Space Complexity O(N*N + M)
    public static int[] solution2(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] res = new int[M];
        int[][] mins = new int[N][N];
        mins[N - 1][N - 1] = getValue(S.charAt(N - 1));
        for (int i = 0; i < N - 1; i++) {
            mins[i][i] = getValue(S.charAt(i));
            if (mins[i][i] > 1) {
                for (int j = i + 1; j < N; j++) {
                    mins[i][j] = Math.min(mins[i][j - 1], getValue(S.charAt(j)));
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if (mins[P[i]][P[i]] == 1) {
                res[i] = 1;
            } else {
                res[i] = mins[P[i]][Q[i]];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mins[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    // Time Complexity O(M+N)
    // Space Complexity O(N*N + M)
    public static int[] solution3(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] res = new int[M];
        int[][] mins = new int[N][4];
        for (int i = 0; i < N; i++) {
            mins[i][getValue(S.charAt(i)) - 1] = 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = P[i]; j <= Q[i]; j++) {
                if (res[i] > 0) {
                    break;
                }
                if (mins[j][0] == 1) {
                    res[i] = 1;
                    break;
                }
            }
            for (int j = P[i]; j <= Q[i]; j++) {
                if (res[i] > 0) {
                    break;
                }
                if (mins[j][1] == 1) {
                    res[i] = 2;
                    break;
                }
            }
            for (int j = P[i]; j <= Q[i]; j++) {
                if (res[i] > 0) {
                    break;
                }
                if (mins[j][2] == 1) {
                    res[i] = 3;
                    break;
                }
            }
            for (int j = P[i]; j <= Q[i]; j++) {
                if (res[i] > 0) {
                    break;
                }
                if (mins[j][3] == 1) {
                    res[i] = 4;
                    break;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mins[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    // the O(N) time and space Complexity is the segment tree
    // O(log N) to search the tree
    // O(N) to construct it
    public static int[] solutionST(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] res = new int[M];
        int[] val = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = getValue(S.charAt(i));
        }
        // construct a tree from an array
        // left of i 2*i + 1
        // right of i 2*i + 2
        // root of i (i - 1)/2
        return res;
    }

    public static void constructSegmentTree(int[] arr, int[] segTree, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        // left
        constructSegmentTree(arr, segTree, low, mid, 2 * pos + 1);
        // right
        constructSegmentTree(arr, segTree, mid, high, 2 * pos + 2);
        // root
        segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }

    public static void main(String[] args) {
        // 2 1 3 2 2 4 1
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })));
        // {2, 4 ,1}
        System.out.println(Arrays.toString(solution2("CAGCCTA", new int[] { 2, 5, 0, 1 }, new int[] { 4, 5, 6, 4 })));

        System.out.println(Arrays.toString(solution3("CAGCCTA", new int[] { 2, 5, 0, 1 }, new int[] { 4, 5, 6, 4 })));

        System.out.println(Arrays.toString(solutionST("CAGCCTA", new int[] { 2, 5, 0, 1 }, new int[] { 4, 5, 6, 4 })));

    }
}