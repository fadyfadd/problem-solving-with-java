import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PerfectSquareChecker {

    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num <= 1) {
            return true;
        }

        int value = 1;
        while (value * value < num) {
            value++;
        }

        System.out.println(value * value);
        return value * value == num;
    }

    @Test
    void isPerfectSquare_1() {

        assertTrue(PerfectSquareChecker.isPerfectSquare(0));
        assertTrue(PerfectSquareChecker.isPerfectSquare(1));
        assertTrue(PerfectSquareChecker.isPerfectSquare(4));
        assertTrue(PerfectSquareChecker.isPerfectSquare(9));
        assertTrue(PerfectSquareChecker.isPerfectSquare(16));
        assertTrue(PerfectSquareChecker.isPerfectSquare(25));
        assertTrue(PerfectSquareChecker.isPerfectSquare(100));
    
    }

}
