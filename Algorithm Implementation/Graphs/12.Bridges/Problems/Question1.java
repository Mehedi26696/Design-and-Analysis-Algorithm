
//https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.*;

public class Question1 {

    static class Edge {

        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
             
        }
    }


    public static  List<List<Integer>> criticalConnectionsUtil( List<List<Integer>>graph, int curr, int par, boolean visited[], int disc[], int low[], int time, List<List<Integer>> result) {
        visited[curr] = true;
        disc[curr] = low[curr] = ++time;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            int neigh = graph.get(curr).get(i); // Get the neighbor node

            if (neigh == par) {
                continue; // Skip parent node
            } else if (!visited[neigh]) {
                criticalConnectionsUtil(graph, neigh, curr, visited, disc, low, time, result);
                low[curr] = Math.min(low[curr], low[neigh]); // Update low value of curr for parent function calls

                // If the lowest vertex reachable from subtree under curr is below curr in DFS tree, then curr-neigh is a bridge
                if (low[neigh] > disc[curr]) {
                    result.add(Arrays.asList(curr, neigh));
                }
            } else {
                low[curr] = Math.min(low[curr], disc[neigh]); // Update low value of curr for parent function calls
            }
        }
        return result;

    }
    public static List<List<Integer>> criticalConnections(int n,List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        int[] disc = new int[n]; // Discovery times of visited vertices
        int[] low = new int[n]; // Earliest visited vertex reachable from subtree
        List<List<Integer>> result = new ArrayList<>(); // To store the bridges

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
               result =  criticalConnectionsUtil(graph, i, -1, visited, disc, low, 0, result);
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt(); // Number of nodes
        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt(); // Number of edges

        // Adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        

        // Read the edges
        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // Source node
            int v = sc.nextInt(); // Destination node
            graph.get(u).add(v); // Add edge to the adjacency list
            graph.get(v).add(u); // Add edge to the adjacency list (for undirected graph)
        }

        // Find critical connections
        List<List<Integer>> result = criticalConnections(n, graph);
        System.out.println("Critical Connections: " + result);
    }
}