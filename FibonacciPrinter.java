import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class FibonacciPrinter {

    public static Integer[] printFibonacci(int nbr) {

        var list = new ArrayList<Integer>();

        if (nbr <= 0) {
            System.out.println("No Fibonacci numbers to display.");
            return null;
        }

        int a1 = 0;
        int a2 = 1;

        for (int i = 0; i < nbr; i++) {
            list.add(a1);
            int sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }

        return list.toArray(new Integer[0]);
    }

    @Test
    public void printFibonacci_1() {
        var res = printFibonacci(10);
        System.out.println(res);
        assertArrayEquals(res, new Integer[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 });

    }

}
