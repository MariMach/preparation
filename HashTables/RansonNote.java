import java.util.HashMap;
import java.util.Map;

public class RansonNote {
    public static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : magazine) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : note) {
            if (map.containsKey(s)) {
                if (map.get(s) <= 0) {
                    System.out.println("No");
                    return;
                }
                map.put(s, map.get(s) - 1);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String[] s = new String[] { "give", "me", "one", "grand", "today", "night" };
        String[] a = new String[] { "give", "one", "grand", "today" };

        checkMagazine(s, a);
    }

}