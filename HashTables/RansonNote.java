public class RansonNote {
    public static void checkMagazine(String[] magazine, String[] note) {
        // No
        // Yes
        Map<String, Integer> map = new HashMap<>();
        for (String s : magazine) {
            map.put(s, map.getorDefault(s, 0) + 1);
        }
        for (Strinf s : note) {

        }
        System.out.println("Yes");
    }

    public static void amin() {
        String[] s = new String[] { "give", "me", "one", "grand", "today", "night" };
        String[] a = new String[] { "give", "one", "grand", "today" };

        checkMagazine(s, a);
    }

}