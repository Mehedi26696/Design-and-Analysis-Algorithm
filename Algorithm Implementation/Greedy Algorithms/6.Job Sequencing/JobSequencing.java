

// Problem Statement:
// Given a set of jobs where each job has a deadline and a profit associated with it, 
// schedule the jobs in such a way that you maximize the total profit while ensuring 
// that no two jobs are scheduled at the same time. Each job takes a single unit of time 
// to complete, and a job can only be scheduled if its deadline has not passed.

import java.lang.reflect.Array;
import java.util.*;
public class JobSequencing {

    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Function to schedule jobs to maximize profit

    public static int jobScheduling(ArrayList<Job> jobs) {
        // Sort jobs based on profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.size();
         
        int maxProfit = 0;

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;

        for(int i=0;i<jobs.size();i++){
             
            Job curr = jobs.get(i);
            // Check if the job can be scheduled within its deadline

            if (time < curr.deadline) {
                // Schedule the job
                seq.add(curr.id);
                time++;
                maxProfit += curr.profit;
            }  
        }

        // Print the scheduled jobs
        System.out.println("Scheduled Jobs: " + seq);

        return maxProfit;
    }
    public static void main(String[] args) {
        
        int n = 4; // Number of jobs
         ArrayList<Job> jobs = new ArrayList<>(n);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            
            System.out.print("Enter job id, deadline and profit for job " + (i + 1) + ": ");
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new Job(id, deadline, profit));

             
        }

        int maxProfit = jobScheduling(jobs);
        System.out.println("Maximum Profit: " + maxProfit);
    }
    
}
