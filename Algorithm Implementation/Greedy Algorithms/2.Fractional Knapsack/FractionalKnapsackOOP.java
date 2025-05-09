 
import java.util.Arrays;

public class FractionalKnapsackOOP {

    public static class Item {
        int weight;
        int value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        Item[] items = new Item[weights.length];
        
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        
        // Sort items by value-to-weight ratio in descending order
         Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalValue = 0.0;
        
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }
            
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.ratio * capacity;
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
