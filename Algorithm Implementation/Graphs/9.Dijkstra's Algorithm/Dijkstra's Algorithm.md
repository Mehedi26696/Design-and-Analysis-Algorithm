
# Dijkstra's Algorithm

Dijkstra's Algorithm is a graph traversal algorithm used to find the shortest path from a source node to all other nodes in a weighted graph. It works only with graphs that have non-negative edge weights.

## Key Concepts
1. **Graph Representation**: The graph can be represented using an adjacency list or adjacency matrix.
2. **Priority Queue**: A min-heap is used to efficiently fetch the next node with the smallest distance.
3. **Relaxation**: The process of updating the shortest distance to a node if a shorter path is found.

## Steps of the Algorithm
1. Initialize the distance of the source node to 0 and all other nodes to infinity.
2. Use a priority queue to store nodes along with their current shortest distance.
3. While the priority queue is not empty:
    - Extract the node with the smallest distance.
    - For each neighbor of the current node, calculate the distance through the current node and update if it's smaller than the previously known distance.
4. Repeat until all nodes are processed.

## Java Implementation

```java
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Edge {
         
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));


        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));


        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other) {
            return this.path - other.path; // Compare based on path length
        }
    }

    public static void Dijkstra(ArrayList<Edge> graph[], int src) {
        
        int dist[] = new int[graph.length]; // dist[i] = distance from src to i

        boolean visited[] = new boolean[graph.length]; // visited[i] = true if i is visited

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; // Initialize distances to infinity
        }
        dist[src] = 0; // Distance to source is 0


        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0)); // Add source to the priority queue

        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the node with the smallest distance
            int node = current.node;
            int path = current.path;

            if(!visited[node]) {
                visited[node] = true; // Mark the node as visited

                for (Edge edge : graph[node]) {

                    int u = edge.src; // Current node
                    int v = edge.dest; // Adjacent node
                    int w = edge.weight; // Weight of the edge

                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w; // Update distance to adjacent node
                        pq.add(new Pair(v, dist[v])); // Add adjacent node to the priority queue
                    }
                }
            }
        }

        // Print the shortest distances from source to all nodes
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }

    }


    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Print the graph
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : graph[i]) {
                System.out.print(" -> " + edge.dest + "(" + edge.weight + ")");
            }
            System.out.println();
        }

        int src = 0; // Starting vertex

        Dijkstra(graph, src); // Run Dijkstra's algorithm from the source vertex
        System.out.println("Dijkstra's algorithm completed.");
    }
}
```

## Explanation of the Code
1. **Graph Representation**: The graph is represented as an adjacency matrix.
2. **Priority Queue**: A `PriorityQueue` is used to fetch the node with the smallest distance efficiently.
3. **Relaxation**: The distance to each neighbor is updated if a shorter path is found.

## Complexity
- **Time Complexity**: $O(V^2)$ for adjacency matrix, $O((V + E\log V)$ for adjacency list with a priority queue.
- **Space Complexity**: $O(V)$ for storing distances and visited nodes.

## Applications
- GPS navigation systems.
- Network routing protocols.
- Solving shortest path problems in weighted graphs.
