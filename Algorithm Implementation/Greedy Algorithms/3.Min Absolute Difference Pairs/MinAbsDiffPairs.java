 

// Question: Find the minimum absolute difference between pairs of elements from two arrays. 
 

import java.util.*;

public class MinAbsDiffPairs {


    public static int minAbsDiffPairs(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;

        int totalminDiff = 0;

        for (int i = 0; i < n; i++) {
             
            totalminDiff += Math.abs(A[i] - B[i]);
        }
        return totalminDiff;
        
    }

    public static void main(String[] args) {
        
        int n = 5;
        int[] A = {3,2,1,4,5};
        int [] B = {4,6,2,1,3};
        
        System.out.println("Minimum Absolute Difference: " + minAbsDiffPairs(A, B));
        
    }
    
}

// Time Complexity: O(nlogn) for sorting the arrays, and O(n) for calculating the total minimum difference.
