import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static char findFirstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (char ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    public static void main(String args[]) {
        char ch = findFirstNonRepeatedChar("aaggrreennkkp");
        System.out.println(ch);
    }
}