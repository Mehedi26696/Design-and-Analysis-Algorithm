import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionComparator {

    // Activity class to hold start and end times of each activity
    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    // Comparator to sort activities based on their end times
    static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.end - a2.end;
        }
    }

    public static void activity(int start[], int end[], int n) {
        // Create an array of Activity objects
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i], i + 1);
        }

        // Step 1: Sort activities based on their end times using the comparator
        Arrays.sort(activities, new ActivityComparator());

        // Step 2: Select the first activity
        int count = 1; // Count of selected activities
        int firstEndActivity = activities[0].end; // End time of the first activity

        // Store the performed activity in the array
        int[] performedActivities = new int[n];
        performedActivities[0] = activities[0].index; // Mark the first activity as performed

        // Step 3: Iterate through the remaining activities
        for (int i = 1; i < n; i++) {
            if (activities[i].start >= firstEndActivity) {
                count++; // Increment count if the activity can be performed
                firstEndActivity = activities[i].end; // Update the end time of the last selected activity
                performedActivities[count - 1] = activities[i].index; // Store the performed activity
            }
        }

        // Print the performed activities
        System.out.println("Performed activities: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Activity " + performedActivities[i]);
        }

        System.out.println("Total number of activities performed: " + count); // Print the total count of performed activities
    }

    public static void main(String[] args) {
        int n = 5;
        int start[] = {1, 3, 0, 5, 8};
        int end[] = {2, 4, 6, 7, 9};

        activity(start, end, n); // Call the activity selection function
    }
}
