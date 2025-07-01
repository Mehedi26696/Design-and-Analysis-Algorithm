


public class MaxSumInt {

    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]); // Either start a new subarray at arr[i] or extend the previous one
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {9, -3, 1, 7, -15, 2, 3, -4, 2, -7, 6, -2, 8, 4, -9};
        System.out.println("Maximum sum interval (DP): " + maxSubarraySum(arr));
    }
}

// Time Complexity: O(n) 