public class Anagrams {

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
        System.out.println(areAnagram("abba"));
        System.out.println(areAnagram("abcd"));
        System.out.println(areAnagram("ifailuhkqq"));
        System.out.println(areAnagram("kkkk"));
        System.out.println(areAnagram("cdcd"));
    }
}