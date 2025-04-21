
import java.util.*;

public class Prims_Algo_Cost {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // Compare based on cost
        }

    }

    static void primsAlgo(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0)); // Start with the first vertex
        int totalCost = 0; // Total cost of the MST
        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the vertex with the minimum cost
            int vertex = current.vertex;
            int cost = current.cost;

            if (!visited[vertex]) {
                visited[vertex] = true; // Mark the vertex as visited
                totalCost += cost; // Add the cost to the total cost

                for (Edge edge : graph[vertex]) {
                    if (!visited[edge.dest]) {
                        pq.add(new Pair(edge.dest, edge.weight)); // Add the adjacent vertex to the priority queue
                    }
                }
            }
        }

        System.out.println("Total cost of the MST: " + totalCost); // Print the total cost of the MST

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");

        int n = sc.nextInt(); // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[n]; // Create an array of ArrayLists to represent the graph

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>(); // Initialize each ArrayList
        }
        System.out.println("Enter the number of edges in the graph:");

        int m = sc.nextInt(); // Number of edges

        System.out.println("Enter the edges in the format: src dest weight (0-indexed):");
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt(); // Source vertex
            int dest = sc.nextInt(); // Destination vertex
            int weight = sc.nextInt(); // Weight of the edge

            graph[src].add(new Edge(src, dest, weight)); // Add the edge to the graph
            graph[dest].add(new Edge(dest, src, weight)); // Add the edge in the opposite direction for undirected graph
        }
        sc.close(); // Close the scanner

        System.out.println("Graph created successfully.");
        System.out.println("Running Prim's Algorithm to find the cost of the Minimum Spanning Tree (MST)...");
        primsAlgo(graph); // Call the Prim's algorithm function to find the MST cost

    }

}