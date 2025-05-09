import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims_Algo_Cost_Edge {

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
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int vertices = sc.nextInt(); // Read the number of vertices from the user

        ArrayList<Edge> graph[] = new ArrayList[vertices]; // Create an array of ArrayLists to represent the graph
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>(); // Initialize each ArrayList in the array
        }

        System.out.println("Enter the number of edges in the graph:");
        int edges = sc.nextInt(); // Read the number of edges from the user
        
        System.out.println("Enter the edges (source, destination, weight):");
        for(int i=0;i<edges;i++){
            int src = sc.nextInt(); // Read the source vertex of the edge
            int dest = sc.nextInt(); // Read the destination vertex of the edge
            int weight = sc.nextInt(); // Read the weight of the edge

            graph[src].add(new Edge(src, dest, weight)); // Add the edge to the graph
            graph[dest].add(new Edge(dest, src, weight)); // Add the reverse edge to make it undirected
        }

        System.out.println("Graph created successfully.");
        System.out.println("Running Prim's Algorithm to find the edges of the Minimum Spanning Tree (MST)...");
        primsAlgo(graph); // Call the Prim's algorithm function to find the MST edges

    }

}
