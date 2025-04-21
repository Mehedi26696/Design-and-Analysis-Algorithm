# Finding All Paths in a Graph Using DFS

Depth-First Search (DFS) is a powerful algorithm for traversing or searching through graph data structures. It can be used to find all possible paths between two nodes in a graph.

## Key Concepts

1. **Graph Representation**:
    - Use adjacency lists or adjacency matrices to represent the graph.
    - The graph can be directed or undirected.

2. **DFS Traversal**:
    - Start from the source node.
    - Explore each neighbor recursively until the destination node is reached or all paths are explored.

3. **Backtracking**:
    - Use backtracking to explore all possible paths.
    - Remove the current node from the path once all its neighbors are visited.

## Algorithm Steps

1. **Initialize**:
    - Create a list to store the current path.
    - Create a list of all paths to store the results.

2. **DFS Function**:
    - Add the current node to the path.
    - If the current node is the destination, add the path to the result list.
    - Otherwise, recursively visit all unvisited neighbors.
    - Backtrack by removing the current node from the path.

3. **Call DFS**:
    - Start the DFS from the source node.
 

```java
import java.util.ArrayList;

public class AllPath { 

     static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example edges
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    
     public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        

        if(src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge edge = graph[src].get(i);
             
            if(!path.contains(String.valueOf(edge.dest))) { // Check if the destination is already in the path to avoid cycles
                // Add the edge to the path and recursively call for the destination vertex
                printAllPath(graph, edge.dest, dest, path + src + " -> ");
            }
        }

    }
    
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // print graph
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }


        int src = 5;
        int dest = 1;
        
        System.out.println("All paths from " + src + " to " + dest + ":");
        printAllPath(graph, src, dest, "");
        
    }
}
```

## Applications
- Network routing.
- Solving puzzles like mazes.
- Analyzing dependencies in systems.

## Complexity
- **Time Complexity**: O(V + E) for traversal, but finding all paths can be exponential in the worst case.
- **Space Complexity**: O(V) for recursion stack and path storage.

