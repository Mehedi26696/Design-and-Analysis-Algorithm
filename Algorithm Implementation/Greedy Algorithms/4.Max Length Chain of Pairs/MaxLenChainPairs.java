 

// LeetCode Problem: 646. Maximum Length of Pair Chain
// Link: https://leetcode.com/problems/maximum-length-of-pair-chain/description/

import java.util.*;

public class MaxLenChainPairs {

    public static int findLongestChain(int[][] pairs) {

        // Sort the pairs based on the second element of each pair
        // Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));


        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                if (pairs[i][1] > pairs[j][0]) {
                    int[] temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
                }
            }
        }



        
        int count = 0;
        int end = Integer.MIN_VALUE;
        
        for (int i = 0; i < pairs.length; i++) {
            // If the current pair's start is greater than the end of the last selected pair
            if (pairs[i][0] > end) {
                count++; // Increment the count of pairs in the chain
                end = pairs[i][1]; // Update the end to the end of the current pair
            }
        }
        
        return count;
    }

    public static void main(String[] args) {

        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println("Maximum Length of Pair Chain: " + findLongestChain(pairs));
        
    }
    
}
