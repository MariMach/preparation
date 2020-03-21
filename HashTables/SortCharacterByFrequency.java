import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharacterByFrequency {

    public static String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder st = new StringBuilder(n);
        int m = map.size();
        for (int j = 0; j < m; j++) {
            char c = getMaxFreq(map);
            for (int i = 0; i < map.get(c); i++) {
                st.append(c);
            }
            map.remove(c);
        }
        return st.toString();
    }

    public static Character getMaxFreq(Map<Character, Integer> map) {
        int max = 0;
        char c = 'a';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("abba"));
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

}