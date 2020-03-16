/*
 * 
 * 
 * One Away: There are three types of edits that can be performed on strings insert a character, 
 * remove a character, or replace a character.
 * Given two strings, write a function to check of they are one edit (or zero edits away)
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *  
 */
public class OneAway {

    // time complexity is O(n)
    // space complexity is O(1)
    public static boolean oneAway(String a, String b) {
        if (a.length() == b.length()) {
            return oneEditAway(a, b);
        } else if (a.length() + 1 == b.length()) {
            return oneInsertAway(b, a);
        } else if (a.length() - 1 == b.length()) {
            return oneInsertAway(a, b);
        }
        return false;
    }

    public static boolean oneInsertAway(String a, String b) {
        // pale ple
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String a, String b) {
        boolean foundDiff = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         * pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false
         */
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));

    }
}