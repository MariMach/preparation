public class Anagrams {

    // O(n log n)
    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null)
            return false;
        if (first.length() != second.length())
            return false;

        char[] array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        char[] array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
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
        System.out.println(areAnagram("abba", "aabb"));
        System.out.println(areAnagram("abcd", "abcd"));
    }
}