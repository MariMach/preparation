import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {

    public static char firstRepeatedCharacter(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public static void main(String args[]) {
        System.out.println(firstRepeatedCharacter("aabcdefgghjt"));
    }
}