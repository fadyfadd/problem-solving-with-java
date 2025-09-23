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

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); 
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));     
        System.out.println(maxProfit(new int[]{1}));              
        System.out.println(maxProfit(new int[]{}));                
    }
}
