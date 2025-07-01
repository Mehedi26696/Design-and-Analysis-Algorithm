

//https://leetcode.com/problems/target-sum/description/




public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the target is out of bounds, return 0
        if (target > sum || target < -sum) {
            return 0;
        }
        
        // Calculate the new target for subset sum
        int newTarget = (sum + target) / 2;
        
        // If the new target is not an integer, return 0
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        
        return countSubsetSum(nums, newTarget);
    }

    private static int countSubsetSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        // Initialize the first column to 1 (one way to achieve sum 0)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        
        System.out.println("Number of ways to achieve the target sum: " + findTargetSumWays(nums, target));
    }
    
}
