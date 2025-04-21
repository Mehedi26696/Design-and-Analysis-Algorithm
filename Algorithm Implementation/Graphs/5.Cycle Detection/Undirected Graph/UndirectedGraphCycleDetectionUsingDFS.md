# Cycle Detection in an Undirected Graph Using DFS

This document explains the implementation of cycle detection in an undirected graph using Depth First Search (DFS) in Java. Below is a detailed explanation of the approach and key notes to understand the algorithm.
 
## Approach

1. **Graph Representation**:
    - The graph is represented using an adjacency list.
    - Each node points to a list of its adjacent nodes.

2. **DFS Traversal**:
    - Use a recursive DFS function to traverse the graph.
    - Maintain a `visited` array to track visited nodes.
    - Pass the current node and its parent node to the DFS function.

3. **Cycle Detection Logic**:
    - If a visited node is encountered during DFS and it is not the parent of the current node, a cycle is detected.

## Algorithm

1. Initialize a `visited` array of size equal to the number of nodes in the graph.
2. For each unvisited node, call the DFS function.
3. In the DFS function:
    - Mark the current node as visited.
    - For each adjacent node:
      - If it is not visited, recursively call DFS with the current node as the parent.
      - If it is visited and not the parent, a cycle is detected.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycleDetectionUsingDFS {
     public static void main(String[] args) {
          int vertices = 5;
          List<List<Integer>> graph = new ArrayList<>();
          
          // Initialize adjacency list
          for (int i = 0; i < vertices; i++) {
                graph.add(new ArrayList<>());
          }
          
          // Add edges
          addEdge(graph, 0, 1);
          addEdge(graph, 1, 2);
          addEdge(graph, 2, 3);
          addEdge(graph, 3, 4);
          addEdge(graph, 4, 1); // This edge creates a cycle
          
          // Check for cycle
          boolean hasCycle = isCyclePresent(graph, vertices);
          System.out.println("Cycle detected: " + hasCycle);
     }

     private static void addEdge(List<List<Integer>> graph, int u, int v) {
          graph.get(u).add(v);
          graph.get(v).add(u);
     }

     private static boolean isCyclePresent(List<List<Integer>> graph, int vertices) {
          boolean[] visited = new boolean[vertices];
          
          for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                     if (dfs(graph, i, -1, visited)) {
                          return true;
                     }
                }
          }
          return false;
     }

     private static boolean dfs(List<List<Integer>> graph, int current, int parent, boolean[] visited) {
          visited[current] = true;
          
          for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                     if (dfs(graph, neighbor, current, visited)) {
                          return true;
                     }
                } else if (neighbor != parent) {
                     return true;
                }
          }
          return false;
     }
}
```

## Notes

- **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.
- **Space Complexity**: O(V) for the `visited` array and recursion stack.
- This approach works only for undirected graphs. For directed graphs, a different algorithm is required.
- Ensure the graph is connected; otherwise, run the DFS for each disconnected component.

 
