 

import java.util.Arrays;

public class FractionalKnapsack {

    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        double totalValue = 0.0;
        double[] ratio = new double[weights.length];


        // Step 1: Calculate value-to-weight ratio for each item
        
        for (int i = 0; i < weights.length; i++) {
            ratio[i] = (double) values[i] / weights[i];
        }
        
        // Step 2: Sort items by value-to-weight ratio in descending order
        // for (int i = 0; i < ratio.length - 1; i++) {
        //     for (int j = 0; j < ratio.length - i - 1; j++) {
        //         if (ratio[j] < ratio[j + 1]) {
        //             // Swap ratios
        //             double tempRatio = ratio[j];
        //             ratio[j] = ratio[j + 1];
        //             ratio[j + 1] = tempRatio;
                    
        //             // Swap corresponding weights and values
        //             int tempWeight = weights[j];
        //             weights[j] = weights[j + 1];
        //             weights[j + 1] = tempWeight;
                    
        //             int tempValue = values[j];
        //             values[j] = values[j + 1];
        //             values[j + 1] = tempValue;
        //         }
        //     }
        // }


        // or

         Arrays.sort(ratio); // Sort the ratios in descending order
        
        // Step 3: Pick items in sorted order until the capacity is full

        for (int i = 0; i < weights.length; i++) {
            if (capacity <= 0) {
                break;
            }
            
            if (weights[i] <= capacity) {
                totalValue += values[i];
                capacity -= weights[i];
            } else {
                totalValue += ratio[i] * capacity;
                capacity = 0;
            }
        }
        return totalValue;
    }
    
    public static void main(String[] args) {
        int n = 3; // Number of items

        int[] weights = {30, 10, 20};
        int[] values = {120, 60, 100};
        
        int capacity = 50;
        
        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}


// Time Complexity: O(n^2) for sorting the items based on value-to-weight ratio, where n is the number of items. The second loop runs in O(n) time, making the overall time complexity O(n^2).