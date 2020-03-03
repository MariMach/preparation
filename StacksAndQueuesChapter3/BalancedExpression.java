import java.util.Stack;

public class BalancedExpression {

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
                if (bracketsDoesNotMatch(top, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '<' || ch == '{' || ch == '[';
    }

    private static boolean isRightBracket(char ch) {
        return ch == ')' || ch == '>' || ch == '}' || ch == ']';
    }

    private static boolean bracketsDoesNotMatch(char left, char right) {
        return (right == ')' && left != '(') || (right == '}' && left != '{') || (right == ']' && left != '[')
                || (right == '>' && left != '<');
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("abcd [{}}]()e()fghe"));
        System.out.println(isBalanced("123456()(())78_[];lkjhgfdsazcvbnm,."));
    }
}