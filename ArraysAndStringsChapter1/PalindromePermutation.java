/*
 * 
 * 
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 * 
 * 
 */
public class PalindromePermutation {

    // time complexity is O(n)
    // space complexity is O(c)
    public static boolean isPalindromePermutation(String s) {
        // case insensitive
        // get rid of extra space
        s = s.replaceAll(" +", "").toLowerCase();
        int[] char_set = new int[256];
        int odds = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            char_set[val]++;
        }
        for (int i : char_set) {
            // 0 % 2 == 0
            if (i % 2 != 0)
                odds++;
        }
        return odds == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tac t  Coa"));
    }
}