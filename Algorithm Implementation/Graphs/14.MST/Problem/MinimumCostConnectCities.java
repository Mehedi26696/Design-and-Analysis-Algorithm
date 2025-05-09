
// https://www.geeksforgeeks.org/minimum-cost-connect-cities/

//There are n cities and there are roads in between some of the cities. Somehow all the roads are damaged simultaneously. We have to repair the roads to connect the cities again.
// There is a fixed cost to repair a particular road. Input is in the form of edges {u, v, w} where, u and v are city indices. w is the cost to rebuild the road between u and v. 
// Print out the minimum cost to connect all the cities by repairing roads. 

import java.util.*;

public class MinimumCostConnectCities {

    static class Edge {

        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
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

    public static void minCost(ArrayList<Edge> graph[], int n, int m) {

        boolean visited[] = new boolean[n + 1]; // To keep track of visited vertices

        ArrayList<Edge> mst = new ArrayList<>(); // To store the edges of the MST
        int totalCost = 0; // To store the total cost of the MST

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0, 1)); // Start from vertex 1 with cost 0

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

                for (Edge e : graph[vertex]) {
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight, vertex)); // Add the edge to the priority queue
                    }
                }
            }
        }

        // Print the edges of the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
        System.out.println("Total cost of the Minimum Spanning Tree: " + totalCost);
        return; // Return the total cost of the MST
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of cities: ");
        int n = sc.nextInt();

        System.out.println("Enter number of roads: ");
        int m = sc.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[n + 1]; // Create an array of ArrayLists to represent the graph

        for (int i = 0; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        System.out.println(
                "Enter the edges as {u, v, w} where u and v are city indices and w is the cost to rebuild the road between u and v: ");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }
        System.out.println("Minimum cost to connect all cities: ");
        minCost(graph, n, m); // Call the function to find the minimum cost to connect all cities

    }

}