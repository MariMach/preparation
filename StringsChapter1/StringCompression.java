/*
 * 
 * 
 * String Conpression: Implement a method to perform basic string compression using the counts of repeated character.
 * for example: the string aabcccccaaa would become a2b1c5a3.
 * if the compressed string would not become smaller than the original string, your method sould return the original string.
 * you can assume the string has only uppercase and lowercase letters (a-zA-Z)
 */
public class StringCompression {

    // time complexity is O(n)
    // space complexity is O(n)
    public static String compress(String a) {
        StringBuilder st = new StringBuilder();
        int n = a.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            if (i + 1 >= n || a.charAt(i) != a.charAt(i + 1)) {
                st.append(a.charAt(i) + "" + count);
                count = 0;
            }
        }
        return st.length() < n ? st.toString() : a;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}