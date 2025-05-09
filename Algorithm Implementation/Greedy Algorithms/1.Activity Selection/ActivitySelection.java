

import java.util.*;
public class ActivitySelection{

     
    public static void activity(int start[], int end[], int n) {
        
        // Step 1: Sort activities based on their end times
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = 0; j < n - i - 1; j++) {
        //         if (end[j] > end[j + 1]) {
        //             // Swap end times
        //             int tempEnd = end[j];
        //             end[j] = end[j + 1];
        //             end[j + 1] = tempEnd;

        //             // Swap start times accordingly
        //             int tempStart = start[j];
        //             start[j] = start[j + 1];
        //             start[j + 1] = tempStart;
        //         }
        //     }
        // }

        // or

      //  Arrays.sort(end); // Sort the end times

        // Step 2: Select the first activity
        int count = 1; // Count of selected activities
        int  firstendactivity = end[0]; // End time of the first activity

        // Store the performed activity in the array
        int[] performedActivities = new int[n];

        performedActivities[0] = 1; // Mark the first activity as performed

        // Step 3: Iterate through the remaining activities
        for (int i = 1; i < n; i++) {
            
            if( start[i] >= firstendactivity) {
                count++; // Increment count if the activity can be performed
                firstendactivity = end[i]; // Update the end time of the last selected activity

                performedActivities[count - 1] = i + 1; // Store the performed activity
            }
        }

        // Print the performed activities
        System.out.println("Performed activities: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Activity " + performedActivities[i] + " "); // Print each performed activity
        }

        System.out.println("Total number of activities performed: " + count); // Print the total count of performed activities

        return;
    }
    public static void main(String[] args) {

        int n = 5;
        
        int start[] = {1, 3, 0, 5, 8};
        int end[] = {2, 4, 6, 7, 9};  


        activity(start, end, n); // Call the activity selection function
        
        
    }
}



// Time Complexity: O(n^2) for sorting the activities based on their end times and O(n) for selecting the activities, resulting in a total time complexity of O(n^2).