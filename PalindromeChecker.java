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

    public static void main(String[] args) {
        System.out.println(isNumberPalindrome(121)); // true
    }
}
