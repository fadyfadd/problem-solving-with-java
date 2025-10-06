import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ParenthesisValidator {

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c != ')' && c != '}' && c != ']') {
                    continue;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    void isValidParenthesis_1() {
        assertTrue(ParenthesisValidator.isValidParenthesis("()"));
        assertTrue(ParenthesisValidator.isValidParenthesis("()[]{}"));
        assertTrue(ParenthesisValidator.isValidParenthesis("{[()]}"));
        assertTrue(ParenthesisValidator.isValidParenthesis(""));
    }
}
