public class naiveapproach {
    

    // naive method to find the kth smallest element
    public static int findKthSmallest(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            
            return -1; // Invalid k
            
        }
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            if (count == k - 1) {
                return arr[i];
            }
        }
        return -1; // If not found, though this shouldn't happen with valid input

    }

     
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Kth smallest element is: " + findKthSmallest(arr, k)); 
    }
}
