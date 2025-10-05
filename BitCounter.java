import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BitCounter {
    
    public static List<Integer> countBits(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            res.add(Integer.bitCount(i));
        }

        return res;
    }

    @Test
    public void countBits_1() {
        assertTrue(countBits(5).equals(Arrays.asList(0, 1, 1, 2, 1, 2)));
    }
}
