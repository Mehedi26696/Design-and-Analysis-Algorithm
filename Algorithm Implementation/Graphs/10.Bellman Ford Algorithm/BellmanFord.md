
# Bellman-Ford Algorithm

The Bellman-Ford algorithm is a single-source shortest path algorithm that computes the shortest paths from a source vertex to all other vertices in a weighted graph. It can handle graphs with negative weight edges, unlike Dijkstra's algorithm. However, it cannot handle graphs with negative weight cycles.

## Key Features
1. **Handles Negative Weights**: Works with graphs containing negative edge weights.
2. **Detects Negative Cycles**: Identifies if a negative weight cycle exists in the graph.
3. **Time Complexity**: $O(V \cdot E)$, where $V$ is the number of vertices and $E$ is the number of edges.

## Algorithm Steps
1. Initialize the distance to all vertices as infinity (`INF`) and the distance to the source as 0.
2. Relax all edges $V-1$ times:
    - For each edge $u \to v$ with weight \(w\), update the distance to $v$ if $dist[u] + w < dist[v]$.
3. Check for negative weight cycles:
    - If a shorter path is found after $V-1$ iterations, a negative weight cycle exists.

---

## Java Implementation

Below is a Java implementation of the Bellman-Ford algorithm:

```java
import java.util.ArrayList;

public class BellmanFordAlgorithm {

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

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }


    public static void bellmanford(ArrayList<Edge> graph[], int src) {
        
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge edge : graph[j]) {

                    int u = edge.src;
                    int v = edge.dest;
                    int weight = edge.weight;
                    
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        //printing the distances

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int V = 5; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0; // Source vertex
        System.out.println("Distance from source vertex " + src + ":");
        bellmanford(graph, src);

        
    }
}
```

 

## Applications
1. **Routing Algorithms**: Used in network routing protocols like RIP (Routing Information Protocol).
2. **Detecting Arbitrage**: Identifies opportunities in financial markets with negative weight cycles.
3. **Graph Analysis**: Useful in scenarios where negative weights are present.

---

## Limitations
1. **Negative Weight Cycles**: Cannot provide shortest paths if such cycles exist.
2. **Time Complexity**: Slower compared to Dijkstra's algorithm for graphs without negative weights.

---

## Conclusion
The Bellman-Ford algorithm is a versatile and powerful tool for finding shortest paths in graphs with negative weights. Its ability to detect negative weight cycles makes it invaluable in various applications.