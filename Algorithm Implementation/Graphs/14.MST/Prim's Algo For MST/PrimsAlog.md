
# Prim's Algorithm for Minimum Spanning Tree (MST)

Prim's Algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) of a connected, undirected graph. It starts with an arbitrary node and iteratively adds the smallest edge that connects a vertex in the growing MST to a vertex outside of it.

## Key Details

### Input
- A graph represented as an adjacency matrix, adjacency list, or edge list.
- The graph must be connected and undirected.
- Optionally, a starting vertex can be specified.

### Output
- A list or set of edges that form the MST.
- The total weight of the MST.

### Algorithm Steps
1. Initialize a priority queue (or min-heap) to store edges based on their weights.
2. Start with an arbitrary vertex and mark it as visited.
3. Add all edges connected to the starting vertex to the priority queue.
4. While the priority queue is not empty:
    - Extract the edge with the smallest weight.
    - If the edge connects to an unvisited vertex:
      - Add the edge to the MST.
      - Mark the vertex as visited.
      - Add all edges connected to the newly visited vertex to the priority queue.
5. Repeat until all vertices are visited or the MST contains \(V-1\) edges, where \(V\) is the number of vertices.


### Java Implementation

```java
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algo_Cost_Edge {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;
        int dest;

        public Pair(int vertex, int cost, int dest) {
            this.vertex = vertex;
            this.cost = cost;
            this.dest = dest;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // Compare based on cost
        }

    }

    static void primsAlgo(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0, 0)); // Start from vertex 0 with cost 0

        ArrayList<Edge> mst = new ArrayList<>(); // To store the edges of the MST
        int totalCost = 0; // To store the total cost of the MST

        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the vertex with the minimum cost
            int vertex = current.vertex;
            int cost = current.cost;

            if (!visited[vertex]) {
                visited[vertex] = true; // Mark the vertex as visited

                totalCost += cost; // Add the cost to the total cost

                // Add the edge to the MST
                // Avoid adding the starting edge with cost 0
                if (cost != 0) {
                    mst.add(new Edge(current.dest, vertex, cost)); // Add the edge to the MST
                }

                // Add all adjacent vertices to the priority queue
                for (Edge edge : graph[vertex]) {
                    if (!visited[edge.dest]) {
                        pq.add(new Pair(edge.dest, edge.weight, vertex)); // Add the adjacent vertex to the priority
                                                                          // queue
                    }
                }
            }

        }

        // Print the edges of the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("From " + edge.src + " to " + edge.dest + " with weight " + edge.weight);
        }
        System.out.println("Total cost of the Minimum Spanning Tree: " + totalCost); // Print the total cost of the MST
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Graph created successfully.");
        System.out.println("Running Prim's Algorithm to find the edges of the Minimum Spanning Tree (MST)...");
        primsAlgo(graph); // Call the Prim's algorithm function to find the MST edges

    }

}

```

### Explanation of the Code
1. **Edge Class**: Represents an edge with a vertex and weight, and implements `Comparable` for priority queue sorting.
2. **Priority Queue**: Used to select the edge with the smallest weight efficiently.
3. **Visited Array**: Tracks visited vertices to avoid cycles.
4. **MST Construction**: Adds edges to the MST and calculates the total weight.
5. **Graph Representation**: The graph is represented as an adjacency matrix.

 


### Complexity
- **Time Complexity**: \(O(E \log V)\), where \(E\) is the number of edges and \(V\) is the number of vertices. This assumes the use of a priority queue for edge selection.
- **Space Complexity**: \(O(V + E)\), for storing the graph and auxiliary data structures.

### Applications
- Network design (e.g., laying cables or pipelines with minimal cost).
- Approximation algorithms for NP-hard problems like the Traveling Salesman Problem.
- Cluster analysis in machine learning.

### Limitations
- Only works for connected graphs. If the graph is disconnected, it will only find the MST for the connected component containing the starting vertex.
- Does not handle negative edge weights differently, as it assumes all edge weights are non-negative.

### Edge Cases
- Graph with only one vertex (MST is empty).
- Graph with all edges having the same weight (any spanning tree is a valid MST).
- Disconnected graph (algorithm will not produce a complete MST).

This implementation ensures that the MST is constructed efficiently and adheres to the properties of a spanning tree.
