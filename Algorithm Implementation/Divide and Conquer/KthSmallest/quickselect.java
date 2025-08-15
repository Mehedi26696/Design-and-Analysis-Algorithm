
// Finding the Kth smallest element in an array using Quickselect algorithm
// This is a more efficient approach than the naive method, with an average time complexity of O(n)
import java.util.Random;    

public class quickselect {

    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3; // Find the 3rd smallest element
        int result = quickSelect(arr, 0, arr.length - 1, k - 1); // k-1 for zero-based index
        System.out.println("Kth smallest element is: " + result); // Output: Kth smallest element is: 7
    }
}
