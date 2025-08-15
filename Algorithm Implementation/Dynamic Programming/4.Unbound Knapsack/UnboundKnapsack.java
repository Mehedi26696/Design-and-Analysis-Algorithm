 

public class UnboundKnapsack {

    static int unboundknapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        if (capacity <= 0 || n == 0) {
            return 0;
        }

        if (weights[n - 1] <= capacity) {
            // Include the nth item and check the value with and without it
            int includeItem = values[n - 1] + unboundknapsackRecursive(weights, values, capacity - weights[n - 1], n);
            int excludeItem = unboundknapsackRecursive(weights, values, capacity, n - 1);
            return Math.max(includeItem, excludeItem);
        } else {
            // If the nth item cannot be included, skip it
            return unboundknapsackRecursive(weights, values, capacity, n - 1);
        }
    }

    static int unboundknapsackMemoization(int[] weights, int[] values, int capacity, int n, int [][] d) {
        // Base case: no items left or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // If the value is already computed, return it
        if (d[n][capacity] != -1) {
            return d[n][capacity];
        }
        // If the weight of the nth item is less than or equal to the capacity
        if (weights[n - 1] <= capacity) {
            // Include the nth item and check the value with and without it
            int includeItem = values[n - 1] + unboundknapsackMemoization(weights, values, capacity - weights[n - 1], n, d);
            int excludeItem = unboundknapsackMemoization(weights, values, capacity, n - 1, d);
            d[n][capacity] = Math.max(includeItem, excludeItem);
        } else {
            // If the nth item cannot be included, skip it
            d[n][capacity] = unboundknapsackMemoization(weights, values, capacity, n - 1, d);
        }
        return d[n][capacity]; 
    }

    static int unboundknapsackDP(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int [][] dp = new int[n + 1][capacity + 1];

        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Include the item and check the value with and without it
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // If the item cannot be included, carry forward the previous value
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }


        // Print the slected items indexes
        int w = capacity;
        System.out.print("Selected items: ");
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print((i - 1) + " "); // Print the index of the item
                w -= weights[i - 1]; // Reduce the capacity by the weight of the included item
            }
        }
        System.out.println(); // New line after printing selected items
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 7;

        int n = weights.length;
        System.out.println("Unbound Knapsack Recursive: " + unboundknapsackRecursive(weights, values, capacity, n));
        int [][] dp = new int[n + 1][capacity + 1];
        // Initialize dp array with -1 for memoization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Unbound Knapsack Memoization: " + unboundknapsackMemoization(weights, values, capacity,n, dp));
        System.out.println("Unbound Knapsack DP: " + unboundknapsackDP(weights, values, capacity));

        
    }
    
}



// Time Complexity:

// Recursive: O(2^n) in the worst case
// Memoization: O(n * capacity) due to the memoization table
// DP: O(n * capacity) due to the 2D array used for storing results