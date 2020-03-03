import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class BalancedExpression {

    private static final List rightBrackets = Arrays.asList('(', '<', '[', '{');
    private static final List leftBrackets = Arrays.asList(')', '>', ']', '}');

    public static boolean isBalanced(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }
            if (isRightBracket(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!bracketsMatch(top, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isLeftBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private static boolean isRightBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private static boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("abcd [{}}]()e()fghe"));
        System.out.println(isBalanced("123456()(())78_[];lkjhgfdsazcvbnm,."));
    }
}