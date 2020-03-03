import java.util.Stack;

public class ReverseAString {

    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        /*
         * int n = input.length(); for (int i = 0; i < n; i++) {
         * stack.push(input.charAt(i)); }
         */
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcd efghe"));
        System.out.println(reverse("12345678_[];lkjhgfdsazcvbnm,."));
    }
}