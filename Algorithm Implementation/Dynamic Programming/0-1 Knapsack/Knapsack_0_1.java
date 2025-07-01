
public class Knapsack_0_1 {

    static int knapsackRecursion(int[] weights, int[] values, int capacity, int n) {
       
        // Base case: no items left or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // If the weight of the nth item is less than the capacity 

        if (weights[n - 1] <= capacity) {
            // Include the nth item and check the value with and without it
            int includeItem = values[n - 1] + knapsackRecursion(weights, values, capacity - weights[n - 1], n - 1);
            int excludeItem = knapsackRecursion(weights, values, capacity, n - 1);
            return Math.max(includeItem, excludeItem);
        } else {
            // If the nth item cannot be included, skip it
            return knapsackRecursion(weights, values, capacity, n - 1);
        }
    }

    static int KnapsackMemoization(int[] weights, int[] values, int capacity, int n, Integer[][] d) {
        // Base case: no items left or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // If the value is already computed, return it
        if (d[n][capacity] != null) {
            return d[n][capacity];
        }
        // If the weight of the nth item is less than or equal to the capacity
        if (weights[n - 1] <= capacity) {
            // Include the nth item and check the value with and without it
            int includeItem = values[n - 1] + KnapsackMemoization(weights, values, capacity - weights[n - 1], n - 1, d);
            int excludeItem = KnapsackMemoization(weights, values, capacity, n - 1, d);
            d[n][capacity] = Math.max(includeItem, excludeItem);
        } else {
            // If the nth item cannot be included, skip it
            d[n][capacity] = KnapsackMemoization(weights, values, capacity, n - 1, d);
        }
        return d[n][capacity]; 
    }

    static int KnapsackTabulation(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // here dp[i][w] will store the maximum value that can be obtained with the first i items and capacity w

        // Build the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]); 
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int capacity = 50;

        System.out.println("Maximum value in Knapsack = " + knapsackRecursion(weights, values, capacity, weights.length));

        // Memoization approach
        Integer[][] d = new Integer[weights.length + 1][capacity + 1];

        // in d 2d array, we will store the maximum value for each capacity and number of items
        // for example, d[i][j] will store the maximum value for the first i items and capacity j

        int maxValue = KnapsackMemoization(weights, values, capacity, weights.length, d);
        System.out.println("Maximum value in Knapsack using Memoization = " + maxValue);

        // Tabulation approach
        int maxValueTabulation = KnapsackTabulation(weights, values, capacity);
        System.out.println("Maximum value in Knapsack using Tabulation = " + maxValueTabulation);
    }
}
