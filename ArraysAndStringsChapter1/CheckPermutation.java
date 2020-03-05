/*
 * 
 * 
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
 * 
 * 
 */
public class CheckPermutation {
    // solution 1 sort the two strings and compare them
    // solution 2 count the characters in each string and compare them

    // time complexity is O(n)
    // n is the length of the string
    // space complexity is O(c)
    // c the length of the char set
    public static boolean isPermutation(String s, String a) {
        // assuming 256 characters
        if (s.length() != a.length())
            return false;
        int[] char_set = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            char_set[val]++;
        }
        for (int i = 0; i < a.length(); i++) {
            int val = a.charAt(i);
            char_set[val]--;
            if (char_set[val] < 0) {
                return false;
            }
        }
        return true;
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    // time complexity is O(nlog(n)) the sorting
    // n is the length of the string
    // space complexity is O(1)
    public static boolean isPermutationSort(String s, String a) {
        return s.length() == a.length() && sort(s).equals(sort(a));
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("abcde", "eadcb"));
        System.out.println(isPermutationSort("abcde", "eadcb"));
    }
}