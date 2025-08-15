public class MCM {
    // Function to find the minimum number of multiplications needed
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n + 1][n + 1]; // Increased size by 1
        int[][] s = new int[n + 1][n + 1];  // Increased size by 1

        // dp[i][j] = Minimum number of multiplications needed to compute the matrix A[i]A[i+1]...A[j]
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) { // Start from 1 instead of 0
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i-1] * p[k] * p[j]; // Modified formula
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        s[i][j] = k; // Store the index of the split
                    }
                }
            }
        }
        // Print the optimal parenthesization
        System.out.print("Optimal Parenthesization: ");
        printParenthesis(s, 1, n); // Start from 1 instead of 0
        System.out.println();
        return dp[1][n]; // Return dp[1][n] instead of dp[0][n-1]
    }

    // Helper function to print the parenthesis
    private static void printParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i); // Changed from (i + 1) to i
            return;
        }
        System.out.print("(");
        printParenthesis(s, i, s[i][j]);
        System.out.print(" x ");
        printParenthesis(s, s[i][j] + 1, j);
        System.out.print(")");
    }

    public static void main(String[] args) {
        // Example: Dimensions of matrices are 10x30, 30x5, 5x60
        int[] arr = {10, 30, 5, 60};
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr));
    }
}





// Time Complexity: O(n^3)

// Because we have three nested loops:
// 1. The outer loop runs for lengths of subchains (O(n))
// 2. The middle loop runs for the starting index of the subchain (O(n))
// 3. The innermost loop runs for the split point (O(n))


// Space Complexity: O(n^2)
// where n is the number of matrices