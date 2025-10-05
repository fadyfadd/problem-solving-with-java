import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;


public class CoinChange {

    public static int minCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                if (dp[x - coin] != Integer.MAX_VALUE) {
                    dp[x] = Math.min(dp[x], dp[x - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void minCoinChange_1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = minCoinChange(coins, amount);
        assertTrue(result == 3); 
    }
}
