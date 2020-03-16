/*
 * 
 * 
 * String Rotation: Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").
 * 
 * 
 */
public class StringRotation {

    // time complexity is O(n) contains
    // space complexity is O(1)
    public static boolean isStringRotation(String s, String a) {
        if (a == null || s == null) {
            return false;
        }
        return (s.length() == a.length() && (s + s).contains(a));
    }

    public static void main(String[] args) {
        System.out.println(isStringRotation("erbottlewat", "waterbottle"));
        System.out.println(isStringRotation("", ""));
        System.out.println(isStringRotation("abc", "abc"));

        // false permutation not a rotation
        System.out.println(isStringRotation("abcdefgh", "ebcdfgha"));
    }
}