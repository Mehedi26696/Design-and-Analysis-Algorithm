
// https://leetcode.com/problems/course-schedule-ii/description/

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Queue;

public class Question2 {

    public static int[] findOrder (int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // build the graph
        // graph[i] = list of courses that depend on course i
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[count++] = course;
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        // if count != numCourses, it means that there is a cycle in the graph
        // and it is impossible to finish all courses

        if (count != numCourses) {
            return new int[0];
        }
        // return the order array as the correct order of courses
        
        return order;
       
    }

    public static void main(String[] args) {
         
        int[][] prerequisites = { { 1, 0 },{2,0},{3,1},{3,2} };

        int result[] = findOrder(4, prerequisites);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
  
    }

}
