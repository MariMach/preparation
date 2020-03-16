/*
 * 
 * 
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 * 
 * 
 */
public class isUnique {

    // time complexity is O(c) ~ O(1)
    // c is the length of character set 256
    // space complexity is O(1)
    public static boolean uniqueChars(String s) {
        // assuming 256 characters
        if (s.length() > 256)
            return false;
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueChars("abcdefghe"));
        System.out.println(uniqueChars("1234567890-=~!@#$%^&*()_+qwertyuiop[];lkjhgfdsazcvbnm,."));
    }
}