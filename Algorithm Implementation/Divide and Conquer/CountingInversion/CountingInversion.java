package CountingInversion;



// This code counts the number of inversions in an array using a modified merge sort algorithm.
// An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].
// The mergeAndCount function merges two halves of the array while counting the inversions.
// The count is incremented when an element from the right half is less than an element from the left half,
// indicating that all remaining elements in the left half are greater than the current element from the right half.
// The main function initializes an array and calls the countInversions function to get the total number of inversions.
// Time complexity is O(n log n) due to the divide and conquer approach, and space complexity is O(n) for the temporary arrays used in merging.


public class CountingInversion {
     
  
    static int countInversions(int[] arr, int left, int right) {
        if (left >= right) {
            return 0; // No inversions in a single element
        }
        
        int mid = (left + right) / 2;
        int count = 0;

        // Count inversions in the left half
        count += countInversions(arr, left, mid);
        // Count inversions in the right half
        count += countInversions(arr, mid + 1, right);
        // Count inversions across the two halves
        count += mergeAndCount(arr, left, mid, right);

        return count;
    }

    static int mergeAndCount(int[] arr, int left, int mid, int right) {
         
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid; // Size of right subarray
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        int count = 0;

        // Merge the two subarrays and count inversions
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += (n1 - i); // Count inversions , means elements left in leftArr are greater than rightArr[j]
            }
        }
        
        // Copy remaining elements of leftArr, if any
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        // Copy remaining elements of rightArr, if any
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }

        return count; // Return the count of inversions
    }
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int result = countInversions(arr, 0, arr.length - 1);
        System.out.println("Number of inversions: " + result); 
    }
}


