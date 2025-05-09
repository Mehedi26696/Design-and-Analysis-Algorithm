import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight; // Compare edges based on their weights
        }
    }

    static class DisjointSet {
        int parent[], rank[];

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Initialize each vertex as its own parent
                rank[i] = 0; // Initialize rank to 0
            }
        }

        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        void union(int a, int b) {
            int parA = find(a); // Find the parent of vertex a
            int parB = find(b); // Find the parent of vertex b

            if (parA != parB) {
                if (rank[parA] < rank[parB]) {
                    parent[parA] = parB; // Attach smaller rank tree under root of higher rank tree
                } else if (rank[parA] > rank[parB]) {
                    parent[parB] = parA; // Attach smaller rank tree under root of higher rank tree
                } else {
                    parent[parB] = parA; // Attach one tree under another
                    rank[parA]++; // Increase the rank of the new root
                }
            }
        }
    }

    public static void kruskal_mst(ArrayList<Edge> edges, int n) {

        Collections.sort(edges); // Sort edges based on their weights

        DisjointSet ds = new DisjointSet(n); // Create a disjoint set for union-find operations
        ArrayList<Edge> mst = new ArrayList<>(); // List to store edges in the minimum spanning tree

        int mstCost = 0; // Variable to store the total weight of the minimum spanning tree

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i); // Get the current edge
            int u = edge.src; // Source vertex of the edge
            int v = edge.dest; // Destination vertex of the edge

            int parA = ds.find(u); // Find the parent of vertex u
            int parB = ds.find(v); // Find the parent of vertex v

            if (parA != parB) { // If u and v are in different sets
                ds.union(u, v); // Union the sets
                mst.add(edge); // Add the edge to the minimum spanning tree
                mstCost += edge.weight; // Add the weight of the edge to the total cost
            }
        }

        System.out.println("Total weight of the minimum spanning tree: " + mstCost); // Print the total weight of the
                                                                                     // minimum spanning tree
        System.out.println("Edges in the minimum spanning tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight); // Print the edges in the minimum
                                                                                      // spanning tree
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");

        int n = sc.nextInt(); // Number of vertices in the graph
        System.out.println("Enter the number of edges in the graph:");
        int m = sc.nextInt(); // Number of edges in the graph

        ArrayList<Edge> edges = new ArrayList<>(); // List to store edges

        System.out.println("Enter the edges in the format: src dest weight");
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt(); // Source vertex
            int dest = sc.nextInt(); // Destination vertex
            int weight = sc.nextInt(); // Weight of the edge
            edges.add(new Edge(src, dest, weight)); // Add edge to the list
        }

        System.out.println("Graph Created Successfully!");

        System.out.println("The minimum spanning tree is:");
        kruskal_mst(edges, n); // Call the function to find the minimum spanning tree
    }
}



// The above code implements Kruskal's algorithm to find the minimum spanning tree of a graph.
// Time Complexity: O(E log E), where E is the number of edges in the graph. This is due to the sorting of edges.
// Space Complexity: O(V), where V is the number of vertices in the graph. This is due to the disjoint set data structure used for union-find operations.

