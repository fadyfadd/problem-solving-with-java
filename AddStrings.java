import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import org.junit.jupiter.api.Test;

public class AddStrings {
    public static String add2Strings(String nbr1, String nbr2) {
        Stack<String> stk = new Stack<>();
        StringBuilder value = new StringBuilder();
        int retain = 0;

        int l = Math.max(nbr1.length(), nbr2.length());
        nbr1 = String.format("%" + l + "s", nbr1).replace(' ', '0');
        nbr2 = String.format("%" + l + "s", nbr2).replace(' ', '0');

        for (int i = l - 1; i >= 0; i--) {
            int sum = Character.getNumericValue(nbr1.charAt(i)) +
                      Character.getNumericValue(nbr2.charAt(i)) +
                      retain;
            if (sum < 10) {
                stk.push(String.valueOf(sum));
                retain = 0;
            } else {
                stk.push(String.valueOf(sum % 10));
                retain = 1;
            }
        }

        if (retain == 1) {
            stk.push("1");
        }

        while (!stk.isEmpty()) {
            value.append(stk.pop());
        }

        return value.toString();
    }

    @Test
    public void add2Strings_1() {
        assertTrue(add2Strings("9", "1").equals("10"));
    }

    @Test
    public void add2Strings_2() {
        assertTrue(add2Strings("9", "101").equals("110"));
    }

    @Test
    public void add2Strings_3() {
        assertTrue(add2Strings("99", "2").equals("101"));
    }

}
