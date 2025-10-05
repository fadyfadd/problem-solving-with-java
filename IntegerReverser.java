import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerReverser {

    public static int reverseInteger(int nbr) {
        int value = 0;

        while (nbr != 0) {
            value = value * 10 + nbr % 10;
            nbr = nbr / 10;
        }

        return value;
    }

    @Test
    public void reverseInteger_1() {
        assertTrue(reverseInteger(452232) == 232254);
    }

    @Test
    public void reverseInteger_2() {
        assertTrue(reverseInteger(1000) == 1);
    }
}
