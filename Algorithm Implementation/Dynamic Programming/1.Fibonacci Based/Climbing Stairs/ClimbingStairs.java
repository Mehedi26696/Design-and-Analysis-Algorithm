

//https://leetcode.com/problems/climbing-stairs/description/

// Climbing Stairs Problem
// Given n stairs, you can climb either 1 or 2 stairs at a time.


public class ClimbingStairs {

    // Function to calculate the number of ways to climb stairs using recursion
    static int usingRecursion(int n) {
        if (n <= 1) {
            return 1; // Base case: 1 way to climb 0 or 1 stairs
        }
        return usingRecursion(n - 1) + usingRecursion(n - 2); // Recursive relation
    }

    // Function to calculate the number of ways to climb stairs using memoization
    static int dpmemoization(int n, int[] d) {
        if (n <= 1) {
            return 1; // Base case: 1 way to climb 0 or 1 stairs
        }
        if (d[n] != 0) { // Check if the value is already computed
            return d[n];
        }
        d[n] = dpmemoization(n - 1, d) + dpmemoization(n - 2, d); // Store the computed value
        return d[n];
    }

    // Function to calculate the number of ways to climb stairs using tabulation
    static int dpTabulation(int n) {
        int[] dp = new int[n + 1]; // Array to store the number of ways to climb stairs
        dp[0] = 1; // Base case: 1 way to climb 0 stairs
        dp[1] = 1; // Base case: 1 way to climb 1 stair

        // Fill the dp array using tabulation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to climb i stairs
        }

        return dp[n]; // Return the number of ways to climb n stairs
    }

    public static void main(String[] args) {
        int n =5; // Number of stairs
        
        // Using recursion
        System.out.println("Number of ways to climb " + n + " stairs using recursion: " + usingRecursion(n));
        
        // Using memoization
        int[] d = new int[n + 1]; // Array to store computed values
        System.out.println("Number of ways to climb " + n + " stairs using memoization: " + dpmemoization(n, d));
        
        // Using tabulation
        System.out.println("Number of ways to climb " + n + " stairs using tabulation: " + dpTabulation(n));
    }
    
}
