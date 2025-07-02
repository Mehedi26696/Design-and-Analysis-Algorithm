public class Fibonacci {

    // Function to calculate Fibonacci number using recursion

    static int usingRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return usingRecursion(n - 1) + usingRecursion(n - 2);
    }

    static int dpmemoization(int n, int[] d) {
        if (n <= 1) {
            return n;
        }
        if (d[n] != 0) { // Check if the value is already computed
            return d[n];
        }
        d[n] = dpmemoization(n - 1, d) + dpmemoization(n - 2, d); // Store the computed value
        return d[n];
    }

    static int dpTabulation(int n) {
        int[] dp = new int[n + 1]; // Array to store Fibonacci numbers
        dp[0] = 0; // Base case
        dp[1] = 1; // Base case

        // Fill the dp array using tabulation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Fibonacci relation
        }

        return dp[n]; // Return the nth Fibonacci number
    }

    public static void main(String[] args) {
        int n = 10;

        // Using recursion
        System.out.println("Fibonacci of " + n + " using recursion is: " + usingRecursion(n));

        // Using memoization
        int[] d = new int[n + 1]; // Array to store computed Fibonacci values
        System.out.println("Fibonacci of " + n + " using memoization is: " + dpmemoization(n, d));

        // Using tabulation
        System.out.println("Fibonacci of " + n + " using tabulation is: " + dpTabulation(n));
    }

}

// Time Complexity:// - Recursion: O(2^n) due to the exponential growth of
// recursive calls.
//// - Memoization: O(n) as each Fibonacci number is computed once and stored.
// - Tabulation: O(n) as it iteratively fills the dp array.
