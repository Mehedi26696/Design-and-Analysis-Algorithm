

# Tarjan's Algorithm and Bridges

## Introduction
Tarjan's Algorithm is a depth-first search (DFS)-based algorithm used to find **bridges** in a graph. A **bridge** is an edge in a graph whose removal increases the number of connected components. Bridges are critical for understanding the structure and resilience of a graph.

---

## Key Concepts

### 1. **Bridges in a Graph**
- A bridge is an edge `(u, v)` such that removing it disconnects the graph.
- Bridges are also called **cut-edges**.
- Useful in network design, articulation point detection, and fault-tolerant systems.

### 2. **Low and Discovery Times**
- **Discovery Time (`disc[]`)**: The time when a node is first visited during DFS.
- **Low Time (`low[]`)**: The smallest discovery time reachable from a node, including its subtree and back edges.

---

## Algorithm Steps

1. **Initialization**:
    - Maintain arrays `disc[]` and `low[]` initialized to `-1`.
    - Use a parent array to track the DFS tree structure.

2. **DFS Traversal**:
    - For each unvisited node, perform DFS.
    - Update `disc[]` and `low[]` values during traversal.

3. **Bridge Detection**:
    - For an edge `(u, v)`, if `low[v] > disc[u]`, then `(u, v)` is a bridge.

---

## Pseudocode

```java
import java.util.ArrayList;

public class Bridges{

    static class Edge {

        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));


        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }
     
    public static void tarjanBridgeUtil(ArrayList<Edge> graph[], int curr,int par, boolean visited[], int disc[], int low[], int time) {
        
        visited[curr] = true;
        disc[curr] = low[curr] = ++time;

        for (Edge edge : graph[curr]) {
            int  neigh = edge.dest;
           
            if (neigh == par){
                 continue; // Skip parent node
            }
            else if (!visited[neigh]) {
                tarjanBridgeUtil(graph, neigh, curr, visited, disc, low, time);
                low[curr] = Math.min(low[curr], low[neigh]); // Update low value of curr for parent function calls
                if (disc[curr] < low[neigh]) { // If the lowest vertex reachable from subtree under neigh is below curr in DFS tree, then curr-neigh is a bridge
                    System.out.println("Bridge: " + curr + " ------- " + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], disc[neigh]); // Update low value of curr for parent function calls
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V){

        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V]; 

        int time = 0;


        for(int i = 0; i < V; i++) {
            if (!visited[i]) {
                tarjanBridgeUtil(graph, i, -1, visited, disc, low, time); // -1 is parent of root node
            }
        }
    }    


    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // printing the graph   
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
        System.out.println("Bridges in the graph are: ");
        tarjanBridge(graph, V); // Find and print bridges in the graph
 
        

    }
}
```

---

## Complexity
- **Time Complexity**: `O(V + E)` where `V` is the number of vertices and `E` is the number of edges.
- **Space Complexity**: `O(V)` for storing `disc[]`, `low[]`, and recursion stack.

 

## Applications
1. Network reliability analysis.
2. Identifying critical connections in distributed systems.
3. Fault-tolerant design in communication networks.

---
 
