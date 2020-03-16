import java.util.HashMap;
import java.util.Map;

public class CryptoSolution {
    public static boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < solution.length; i++) {
            map.put(solution[i][0], solution[i][1]);
        }
        String[] res = new String[3];
        int i = 0;
        for (String s : crypt) {
            StringBuilder st = new StringBuilder();
            for (char c : s.toCharArray()) {
                st.append(map.get(c));
            }
            res[i] = st.toString();
            i++;
        }
        for (int k = 0; k < 3; k++) {
            System.out.println(res[k]);
            if (res[k].length() > 1 && res[k].charAt(0) == '0') {
                return false;
            }
        }
        return Long.parseLong(res[0]) + Long.parseLong(res[1]) == Long.parseLong(res[2]);
    }

    public static void main(String[] args) {
        char[][] sol = new char[][] { { 'O', '0' }, { 'M', '1' }, { 'Y', '2' }, { 'E', '5' }, { 'N', '6' },
                { 'D', '7' }, { 'R', '8' }, { 'S', '9' } };
        String[] s = new String[] { "SEND", "MORE", "MONEY" };
        System.out.println(isCryptSolution(s, sol)); // 9567 + 1085 = 10652
        char[][] sol1 = new char[][] { { 'O', '1' }, { 'T', '0' }, { 'W', '9' }, { 'E', '5' }, { 'N', '4' } };
        String[] s1 = new String[] { "TEN", "TWO", "ONE" };
        System.out.println(isCryptSolution(s1, sol1)); // 054 + 091 = 145
        char[][] sol2 = new char[][] { { 'A', '1' }, { 'T', '0' } };
        String[] s2 = new String[] { "T", "A", "A" };
        System.out.println(isCryptSolution(s2, sol2)); // 0 + 1 = 1
    }
}