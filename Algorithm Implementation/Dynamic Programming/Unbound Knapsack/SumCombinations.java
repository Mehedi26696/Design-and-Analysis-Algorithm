public class SumCombinations {

    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
             
            if (i >= 1) {
                dp[i] += dp[i - 1]; // Using 1
                
            }
            if (i >= 3) {
                dp[i] += dp[i - 3]; // Using 3
            }
            if (i >= 4) {
                dp[i] += dp[i - 4]; // Using 4
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to write " + n + " as sum of 1, 3, 4: " + countWays(n));
    }
}

