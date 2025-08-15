
public class LCS {
    static int lcsRecursion(String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0; // Base case: one string is empty
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

            int includeChar = 1 + lcsRecursion(str1, str2, i - 1, j - 1); // Include character from both strings
            return includeChar; // Return the length of LCS including this character
        } else {
            int excludeStr1 = lcsRecursion(str1, str2, i - 1, j); // Exclude character from str1
            int excludeStr2 = lcsRecursion(str1, str2, i, j - 1); // Exclude character from str2
            return Math.max(excludeStr1, excludeStr2); // Take the maximum of excluding either character
        }
    }

    static int lcsMemoization(String str1, String str2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0; // Base case: one string is empty
        }
        if (dp[i][j] != -1) {
            return dp[i][j]; // Return already computed value
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = 1 + lcsMemoization(str1, str2, i - 1, j - 1, dp); // Include character from both strings
        } else {
            int excludeStr1 = lcsMemoization(str1, str2, i - 1, j, dp); // Exclude character from str1
            int excludeStr2 = lcsMemoization(str1, str2, i, j - 1, dp); // Exclude character from str2
            dp[i][j] = Math.max(excludeStr1, excludeStr2); // Take the maximum of excluding either character
        }
        return dp[i][j];
    }

    static int lcsTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // lcs print

        StringBuilder lcs = new StringBuilder();
        int x = n, y = m;
        while (x > 0 && y > 0) {
            if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
                lcs.append(str1.charAt(x - 1));
                x--;
                y--;
            } else if (dp[x - 1][y] > dp[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }
        System.out.println("LCS: " + lcs.reverse().toString());
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int i = str1.length();
        int j = str2.length();

        int lcsLength = lcsRecursion(str1, str2, i, j);
        System.out.println("Length of LCS: " + lcsLength);
        int[][] dp = new int[i + 1][j + 1];

        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                dp[x][y] = -1; // Initialize DP table with -1
            }
        }

        int lcsMemoLength = lcsMemoization(str1, str2, i, j, dp);
        System.out.println("Length of LCS (Memoization): " + lcsMemoLength);
        int lcsTabLength = lcsTabulation(str1, str2);
        System.out.println("Length of LCS (Tabulation): " + lcsTabLength);

    }
}
