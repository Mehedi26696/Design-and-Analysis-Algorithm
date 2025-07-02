
public class MaxSumIntervalDP {

    public static int[] maxSubarraySumWithIndices(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // dp[i] = max sum ending at i
        int[] startIndices = new int[n]; // startIndices[i] = start index of max subarray ending at i

        dp[0] = arr[0];
        startIndices[0] = 0;

        int maxSum = dp[0];
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > dp[i - 1] + arr[i]) {
                dp[i] = arr[i];
                startIndices[i] = i; // start new interval here
            } else {
                dp[i] = dp[i - 1] + arr[i];
                startIndices[i] = startIndices[i - 1]; // continue previous interval
            }

            if (dp[i] > maxSum) {
                maxSum = dp[i];
                maxStart = startIndices[i];
                maxEnd = i;
            }
        }

        int[] result = new int[3];
        result[0] = maxSum; // Maximum sum
        result[1] = maxStart; // Start index of the maximum sum subarray
        result[2] = maxEnd; // End index of the maximum sum subarray

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 9, -3, 1, 7, -15, 2, 3, -4, 2, -7, 6, -2, 8, 4, -9 };
        int[] result = maxSubarraySumWithIndices(arr);

        System.out.println("Maximum sum interval: " + result[0]);
        System.out.println("Start index: " + result[1]);
        System.out.println("End index: " + result[2]);

        System.out.print("Subarray: [");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(arr[i]);
            if (i < result[2]) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
