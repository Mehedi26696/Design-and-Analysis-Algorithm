
// https://leetcode.com/problems/course-schedule/

// using the topological sort algorithm to check if a cycle exists in the graph
// if a cycle exists, it means that it is impossible to finish all courses


import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Queue;

public class Question1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        Question1 q = new Question1();
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(q.canFinish(2, prerequisites)); // false
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(q.canFinish(2, prerequisites2)); // true
    }
}