

// This code detects cycles in an undirected graph using Depth First Search (DFS).
import java.util.*;

public class UndirectedGraphCycleDetectionUsingDFS {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
      // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

      //  graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean ditectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {

                if (detectCycleUtil(graph, i, visited, -1)) {
                    // cycle existed in one of the components
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], int parent) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            
            if(!visited[e.dest]) {
                // If the destination node is not visited, visit it
                if (detectCycleUtil(graph, e.dest, visited, curr)) {
                    return true;
                }
            } else if (visited[e.dest] && e.dest != parent) {
                // If the destination node is visited and is not the parent of the current node,
                // then a cycle exists
                return true;
            }
        }
        // No cycle found in this path
        return false;
    }

    public static void main(String[] args) {

        /*
         * 0 --------- 3
         * /| |
         * / | |
         * / | |
         * 1 | 4
         * \ |
         * \ |
         * 2
         */

        int V = 5; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        System.out.println("Graph is : ");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }
       
        if(ditectCycle(graph)) {
            System.out.println("Cycle exists in the graph.");
        } else {
            System.out.println("No cycle exists in the graph.");
        }
    }

}


// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and recursion stack space.


