import java.util.*;

public class StockProfit {

    public static int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0]; // Minimum price seen so far
        int maxProfit = 0;        // Maximum profit we can achieve

        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - minPrice;

            if (profitToday > maxProfit) {
                maxProfit = profitToday;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter comma-separated stock prices:");
        String input = sc.nextLine();
        String[] parts = input.split(",");

        int[] prices = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            prices[i] = Integer.parseInt(parts[i].trim());
        }

        int maxProfit = getMaxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}

