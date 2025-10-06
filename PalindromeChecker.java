import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PalindromeChecker {

    public static boolean isNumberPalindrome(int x) {
        int y = x;
        int value = 0;

        while (y != 0) {
            value = value * 10 + (y % 10);
            y = y / 10;
        }

        return x == value;
    }

    @Test
    void isNumberPalindrome_1() {
        assertTrue(PalindromeChecker.isNumberPalindrome(121));
        assertTrue(PalindromeChecker.isNumberPalindrome(12321));
        assertTrue(PalindromeChecker.isNumberPalindrome(0));
        assertTrue(PalindromeChecker.isNumberPalindrome(1));
    }
}
