// Imagine a wall with handholds arranged in a grid.

// At each move, the climber can reach one of three possible handholds:
// directly above, above-left, or above-right.

// Each handhold has an associated "danger rating" provided in a table.
// The total danger of a climbing path is the sum of the danger ratings
// for all handholds visited along that path.

public class ClimbingWalls {

    public static int findMaxDanger(int[][] dangerRatings) {
        int rows = dangerRatings.length;
        if (rows == 0)
            return 0;
        int cols = dangerRatings[0].length;

        // Create a DP table to store the maximum danger ratings
        int[][] dp = new int[rows][cols];

        // Initialize the first row of the DP table
        for (int j = 0; j < cols; j++) {
            dp[0][j] = dangerRatings[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Directly above
                dp[i][j] = dp[i - 1][j] + dangerRatings[i][j];

                // Above-left
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + dangerRatings[i][j]);
                }

                // Above-right
                if (j < cols - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + dangerRatings[i][j]);
                }
            }
        }

        // Find the maximum danger rating in the last row
        int maxDanger = 0;
        for (int j = 0; j < cols; j++) {
            maxDanger = Math.max(maxDanger, dp[rows - 1][j]);
        }

        return maxDanger;
    }

    static int findMinDanger(int[][] dangerRatings) {
        int rows = dangerRatings.length;
        if (rows == 0)
            return 0;
        int cols = dangerRatings[0].length;

        // Create a DP table to store the minimum danger ratings
        int[][] dp = new int[rows][cols];

        // Initialize the first row of the DP table
        for (int j = 0; j < cols; j++) {
            dp[0][j] = dangerRatings[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Directly above
                dp[i][j] = dp[i - 1][j] + dangerRatings[i][j];

                // Above-left
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dangerRatings[i][j]);
                }

                // Above-right
                if (j < cols - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + dangerRatings[i][j]);
                }
            }
        }

        // Find the minimum danger rating in the last row
        int minDanger = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            minDanger = Math.min(minDanger, dp[rows - 1][j]);
        }

        return minDanger;
    }

    static int recursiveMaxDanger(int i, int j, int[][] dangerRatings, int[][] dp) {
        int rows = dangerRatings.length;
        int cols = dangerRatings[0].length;

        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int res = Integer.MIN_VALUE;

            // Directly below
            res = Math.max(res, recursiveMaxDanger(i + 1, j, dangerRatings, dp) + dangerRatings[i][j]);
            // Below-left
            res = Math.max(res, recursiveMaxDanger(i + 1, j - 1, dangerRatings, dp) + dangerRatings[i][j]);
            // Below-right
            res = Math.max(res, recursiveMaxDanger(i + 1, j + 1, dangerRatings, dp) + dangerRatings[i][j]);

            return dp[i][j] = res;
        } else {
            return 0; // Outside matrix
        }
    }

    static int recursiveMinDanger(int i, int j, int[][] dangerRatings, int[][] dp) {
        int rows = dangerRatings.length;
        int cols = dangerRatings[0].length;

        if (j < 0 || j >= cols)
            return Integer.MAX_VALUE; // Out of bounds column

        if (i == rows - 1)
            return dangerRatings[i][j]; // Base case: bottom row

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = recursiveMinDanger(i + 1, j, dangerRatings, dp);
        int downLeft = recursiveMinDanger(i + 1, j - 1, dangerRatings, dp);
        int downRight = recursiveMinDanger(i + 1, j + 1, dangerRatings, dp);

        dp[i][j] = dangerRatings[i][j] + Math.min(down, Math.min(downLeft, downRight));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] dangerRatings = {
                { 2, 8, 9, 5, 8 },
                { 4, 4, 6, 2, 3 },
                { 5, 7, 5, 6, 1 },
                { 3, 2, 5, 4, 8 }
        };

        int maxDanger = findMaxDanger(dangerRatings);
        System.out.println("Maximum danger rating for the climbing path: " + maxDanger);
        int minDanger = findMinDanger(dangerRatings);
        System.out.println("Minimum danger rating for the climbing path: " + minDanger);

        // Test recursive max danger
        int rows = dangerRatings.length;
        int cols = dangerRatings[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1; // Initialize DP table with -1
            }
        }

        int recursiveMaxDangerValue = Integer.MIN_VALUE;
        for (int j = 0; j < cols; j++) {
            recursiveMaxDangerValue = Math.max(recursiveMaxDangerValue, recursiveMaxDanger(0, j, dangerRatings, dp));
        }
        System.out.println("Maximum danger rating for the climbing path (recursive): " + recursiveMaxDangerValue);

        // Test recursive min danger
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1; // Initialize DP table with -1
            }
        }
        int recursiveMinDangerValue = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            recursiveMinDangerValue = Math.min(recursiveMinDangerValue,
                    recursiveMinDanger(0, j, dangerRatings, dp));
        }
        System.out.println("Minimum danger rating for the climbing path (recursive): " + recursiveMinDangerValue);

    }
}
