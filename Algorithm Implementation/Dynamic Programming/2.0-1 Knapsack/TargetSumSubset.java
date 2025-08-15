

// Target Sum subset problem is a classic problem in computer science 
// where we are given a set of integers and a target sum. The goal is to determine if there is a subset of the given set that sums up to the target sum.

public class TargetSumSubset {

    static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // here dp[i][j] will be true if a subset of the first i elements can sum up to j

        // Initialize the first column to true (0 sum is always possible)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; 
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    static boolean isSubsetSumRecursive(int[] arr, int n, int target) {
        // Base cases
        if (target == 0) return true; // Found a subset with the target sum
        if (n == 0) return false; // No elements left to consider
        // If the last element is greater than the target, skip it
        
        if(arr[n-1] <= target) {
            // Include the last element or exclude it

            boolean includeLast = isSubsetSumRecursive(arr, n - 1, target - arr[n - 1]);
            boolean excludeLast = isSubsetSumRecursive(arr, n - 1, target);
            return includeLast || excludeLast;
        } else {
            // Exclude the last element
            return isSubsetSumRecursive(arr, n - 1, target);
        }
    }


    static int countways(int[] arr, int n, int target) {
        // Base cases
        if (target == 0) return 1; // Found a subset with the target sum
        if (n == 0) return 0; // No elements left to consider

        
        if(arr[n-1] <= target) {
            // Include the last element or exclude it
            int includeLast = countways(arr, n - 1, target - arr[n - 1]);
            int excludeLast = countways(arr, n - 1, target);
            return includeLast + excludeLast;
        } else {
            // Exclude the last element
            return countways(arr, n - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 10;
        
        if (isSubsetSum(arr, target)) {
            System.out.println("Found a subset with the given target sum: " + target);
        } else {
            System.out.println("No subset with the given target sum: " + target);
        }

        // Testing the recursive approach
        if (isSubsetSumRecursive(arr, arr.length, target)) {
            System.out.println("Found a subset with the given target sum (recursive): " + target);
        } else {
            System.out.println("No subset with the given target sum (recursive): " + target);
        }


        // Count the number of ways to achieve the target sum
        int ways = countways(arr, arr.length, target);
        System.out.println("Number of ways to achieve the target sum " + target + ": " + ways);
        
    }
    
}
