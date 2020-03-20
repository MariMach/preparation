import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SherlockandAnagrams {

    public static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {

            }
        }
        return count;
    }

    // O(n)
    public static boolean areAnagram(String first, String second) {
        if (first == null || second == null)
            return false;
        if (first.length() != second.length())
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (int i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (int i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }
        return true;
    }

    public static void main(String[] args) {
        // 4
        System.out.println(sherlockAndAnagrams("abba"));
        // 0
        System.out.println(sherlockAndAnagrams("abcd"));
        // 3
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        // 10
        System.out.println(sherlockAndAnagrams("kkkk"));
        // 5
        System.out.println(sherlockAndAnagrams("cdcd"));
    }
}