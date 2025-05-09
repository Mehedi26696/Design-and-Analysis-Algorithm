
import java.util.*;

public class JohnsonAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int u, int v, int w) {
            this.src = u;
            this.dest = v;
            this.weight = w;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    
    // Bellman-Ford algorithm to find shortest paths from a single source

    static int[] bellmanFord(ArrayList<Edge>[] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : graph[u]) {
                    if (dist[u] != INF && dist[edge.dest] > dist[u] + edge.weight) {
                        dist[edge.dest] = dist[u] + edge.weight;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph[u]) {
                if (dist[u] != INF && dist[edge.dest] > dist[u] + edge.weight) {
                    return null; // Negative weight cycle detected
                }
            }
        }

        return dist;
    }

    // Dijkstra's algorithm to find shortest paths from a single source

    static void dijkstra(ArrayList<Edge>[] graph, int source, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});
        dist[source] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0], d = current[1];

            if (d > dist[u]) continue; // Skip if we already found a better path

            for (Edge edge : graph[u]) {
                if (dist[edge.dest] > dist[u] + edge.weight) {
                    dist[edge.dest] = dist[u] + edge.weight;
                    pq.offer(new int[]{edge.dest, dist[edge.dest]});
                }
            }
        }
    }
    static int[][] johnson(ArrayList<Edge>[] graph, int V) {
        // Step 1: Add a new vertex and connect it to all other vertices with zero-weight edges
        
        ArrayList<Edge>[] newGraph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            newGraph[i] = new ArrayList<>();
        }

        for (int u = 0; u < V; u++) {
            for (Edge edge : graph[u]) {
                newGraph[u].add(edge);
            }
            newGraph[V].add(new Edge(V, u, 0)); // Connect new vertex to all other vertices
        }

        // Step 2: Run Bellman-Ford from the new vertex to find potential
        int[] h = bellmanFord(newGraph, V);
        if (h == null) {
            return null; // Negative weight cycle detected
        }


        // Step 3: Reweight the edges
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph[u]) {
                edge.weight += h[u] - h[edge.dest]; // Reweighting
            }
        }
        
        // Step 4: Run Dijkstra's algorithm for each vertex
        int[][] dist = new int[V][V];
        for (int u = 0; u < V; u++) {
            int[] d = new int[V];
            Arrays.fill(d, INF);
            dijkstra(graph, u, d);
            for (int v = 0; v < V; v++) {
                if (d[v] != INF) {
                    dist[u][v] = d[v] + h[v] - h[u]; // Adjust distances
                } else {
                    dist[u][v] = INF;
                }
            }
        }
        // Step 5: Restore original weights

        for (int u = 0; u < V; u++) {
            for (Edge edge : graph[u]) {
                edge.weight -= h[u] - h[edge.dest]; // Restore original weights
            }
        }
        return dist; // Return the distance matrix
    }

      

    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            graph[i] = new ArrayList<>();
        }

        // Add edges: from, to, weight
        graph[0].add(new Edge(0, 1, -2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 2));
        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 1, -1));
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 2));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));


        
        int[][] dist = johnson(graph, V);
        if (dist != null) {
            System.out.println("Shortest paths between all pairs of vertices:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(dist[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Negative weight cycle detected.");
        }


    }
}
