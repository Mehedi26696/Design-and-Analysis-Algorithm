public class MCMMemoization {

    static int[][] dp;

    public static int matrixChainMemoized(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = matrixChainMemoized(arr, i, k) + matrixChainMemoized(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (cost < dp[i][j]) {
                dp[i][j] = cost;
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1; // Initialize dp array with -1
            }
        }

        int minCost = matrixChainMemoized(arr, 1, n - 1); // Start from 1 to n-1
        System.out.println("Minimum number of multiplications is " + minCost);
    }
    
}
