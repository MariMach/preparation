/*
 * 
 * 
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
 * 
 * EXAMPLE
    Input: "Mr John Smith", 13
    Output: "Mr%20John%20Smith"
 * 
 */
public class URLify {

    // time complexity is O(n)
    // n is the length of the string
    // space complexity is O(n)
    public static String urlify(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i) + "");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith"));
        System.out.println(urlify("Hola hola hola lol"));
    }
}