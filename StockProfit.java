import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StockProfit {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            int currentProfit = price - minPrice;
            maxProfit = Math.max(currentProfit, maxProfit);
            minPrice = Math.min(price, minPrice);
        }

        return maxProfit;
    }

    @Test
    void maxProfit_1() {
        assertEquals(5, StockProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
