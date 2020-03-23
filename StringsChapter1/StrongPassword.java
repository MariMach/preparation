public class StrongPassword {
    /*
     * Its length is at least . It contains at least one digit. It contains at least
     * one lowercase English character. It contains at least one uppercase English
     * character. It contains at least one special character. The special characters
     * are: !@#$%^&*()-+ She typed a random string of length in the password field
     * but wasn't sure if it was strong. Given the string she typed, can you find
     * the minimum number of characters she must add to make her password strong?
     * 
     * Note: Here's the set of types of characters in a form you can paste in your
     * solution:
     * 
     * 
     */

    // Complete the minimumNumber function below.
    public static String numbers = "0123456789";
    public static String lower_case = "abcdefghijklmnopqrstuvwxyz";
    public static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String special_characters = "!@#$%^&*()-+";

    public static int minimumNumber(int n, String password) {
        int num = 0;
        int lowercase = 0;
        int uppercase = 0;
        int specialcharacters = 0;
        int min = 0;
        // Return the minimum number of characters to make the password strong
        for (char ch : password.toCharArray()) {
            if (numbers.indexOf(ch) != -1) {
                num++;
            }
            if (lower_case.indexOf(ch) != -1) {
                lowercase++;
            }
            if (upper_case.indexOf(ch) != -1) {
                uppercase++;
            }
            if (special_characters.indexOf(ch) != -1) {
                specialcharacters++;
            }
        }
        if (num <= 0) {
            min++;
        }
        if (lowercase <= 0) {
            min++;
        }
        if (uppercase <= 0) {
            min++;
        }
        if (specialcharacters <= 0) {
            min++;
        }
        if (min + n < 6) {
            min = min + (6 - min - n);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(11, "#HackerRank"));
        System.out.println(minimumNumber(3, "Ab1"));
    }
}