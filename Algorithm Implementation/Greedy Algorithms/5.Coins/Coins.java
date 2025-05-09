 

// Calculate the minim number of coins/notes to make change for a given amount using a set of coins/notes.


import java.lang.reflect.Array;
import java.util.*;
public class Coins {

    public static void main(String[] args) {

       int[] coins = {1, 2,5,10,20,50,100,500,2000}; // coin denominations

       
        
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt(); // amount to make change for

        
       // Arrays.sort(coins, Comparator.reverseOrder()); // sort the coins in descending order

        // or

        for (int i = 0; i < coins.length; i++) { // sort the coins in descending order
            for (int j = i + 1; j < coins.length; j++) {
                if (coins[i] < coins[j]) {
                    int temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;
                }
            }
        }

        

         
        
        int count = 0; // number of coins used  

        ArrayList<Integer> coinsUsed = new ArrayList<>(); // list to store the coins used
        for (int i = 0; i <coins.length; i++) {

            if(coins[i] <= amount) { // if the coin is less than or equal to the amount
                
                while (coins[i] <= amount) { // while the amount is greater than or equal to the coin
                    amount -= coins[i]; // subtract the coin from the amount
                    count++; // increment the count of coins used
                    coinsUsed.add(coins[i]); // add the coin to the list of coins used
                }
            }  
        }
   
        System.out.println("Minimum number of coins/notes required: " + count); // print the number of coins used

        System.out.print("Coins/notes used: "); // print the coins used
        for (int i = 0; i < coinsUsed.size(); i++) { // print the coins used
            System.out.print(coinsUsed.get(i) + " "); // print the coin
        }
        System.out.println(); // print a new line
    }
    
}
