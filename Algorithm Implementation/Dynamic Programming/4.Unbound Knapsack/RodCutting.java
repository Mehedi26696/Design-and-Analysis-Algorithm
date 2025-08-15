 
// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

// Rod Cutting Problem: Given a rod of length n and an array of prices where prices[i] is the price of a rod of length i+1,
//  find the maximum obtainable value by cutting the rod into pieces.
// This is a classic dynamic programming problem that can be solved using a bottom-up approach.

public class RodCutting {

    static int cutRod(int[] prices, int rodLength) {
        int n = prices.length;
        int[][] dp = new int[n + 1][rodLength + 1];
        
        // Build the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= rodLength; j++) {
                if (i <= j) {
                    // Include the piece and check the value with and without it
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] + prices[i - 1]);
                } else {
                    // If the piece cannot be included, carry forward the previous value
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // dp table

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= rodLength; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // how to cut
        int length = rodLength;
        System.out.print("Rod should be cut at lengths: ");
        while (length > 0) {
            for (int i = n; i >= 1; i--) {
                if (i <= length && dp[i][length] == dp[i][length - i] + prices[i - 1]) {
                    System.out.print(i + " ");
                    length -= i;
                    break;
                }
            }
        }
        System.out.println();
        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = prices.length;
        System.out.println("Maximum obtainable value is " + cutRod(prices, rodLength));
    }
    
}
