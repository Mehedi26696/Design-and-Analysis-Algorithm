
import java.util.Arrays;

public class ClosestPairFinder {

    // Public method to find the closest pair whose sum is closest to the target
    public static int[] findClosestPair(int[] arr, int target) {
        if (arr == null || arr.length < 2) return null;

        // Sort the array for efficient divide and conquer
        Arrays.sort(arr);
        return findClosestPairDC(arr, 0, arr.length - 1, target);
    }

    // Recursive divide-and-conquer approach
    private static int[] findClosestPairDC(int[] arr, int left, int right, int target) {
         
        int [] pair = new int[2];
        // Base cases managing small subarrays
        if (right - left == 1) {
            pair[0] = arr[left];
            pair[1] = arr[right];
            return pair;
            
        }
        if (right - left < 1) {
            return null;
        }

        int mid = left + (right - left) / 2;

        // Recursively solve for left and right halves
        int[] leftPair = findClosestPairDC(arr, left, mid, target);
        int[] rightPair = findClosestPairDC(arr, mid + 1, right, target);
        int[] crossPair = findClosestCrossPair(arr, left, mid, right, target);

        // Return the best among the three
        return getBestPair(leftPair, rightPair, crossPair, target);
    }

    // Find best pair with one element from left and one from right
    private static int[] findClosestCrossPair(int[] arr, int left, int mid, int right, int target) {
        int i = mid;
        int j = mid + 1;
        int closestSum = Integer.MAX_VALUE;
        int[] bestPair = new int[2];

        // Use two-pointer approach
        while (i >= left && j <= right) {
            int sum = arr[i] + arr[j];
            int diff = Math.abs(sum - target);
            int minDiff = Math.abs(closestSum - target);

            if (diff < minDiff) {
                closestSum = sum;
                bestPair[0] = arr[i];
                bestPair[1] = arr[j];
              
            }
            // Move pointers to get closer to the target
            if (sum < target) {
                j++;
            } else {
                i--;
            }
        }
        return bestPair;
    }

    // Compare all three pairs and return the one closest to the target
    private static int[] getBestPair(int[] a, int[] b, int[] c, int target) {
        int[] best = null;
        int minDiff = Integer.MAX_VALUE;

        if (a != null) {
            int diff = Math.abs(a[0] + a[1] - target);
            if (diff < minDiff) {
                minDiff = diff;
                best = a;
            }
        }

        if (b != null) {
            int diff = Math.abs(b[0] + b[1] - target);
            if (diff < minDiff) {
                minDiff = diff;
                best = b;
            }
        }

        if (c != null) {
            int diff = Math.abs(c[0] + c[1] - target);
            if (diff < minDiff) {
                best = c;
            }
        }

        return best;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] arr = {10, 2, 7, 3, 1, 9, 4};  // Can be unsorted
        int target = 11;

        int[] result = findClosestPair(arr, target);

        if (result != null) {
            System.out.printf("Closest pair to target %d is: (%d, %d)\n", target, result[0], result[1]);
        } else {
            System.out.println("No valid pair found.");
        }
    }
}

