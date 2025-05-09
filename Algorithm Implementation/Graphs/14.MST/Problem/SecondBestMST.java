
// Minimum Spanning Tree (MST) and Second Minimum Spanning Tree (Second MST) using Prim's algorithm
// This program finds the first and second minimum spanning trees of a connected undirected graph using Prim's algorithm.

import java.util.*;

public class SecondBestMST {

    // Edge class to represent a graph edge
    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Edge edge = (Edge) obj;
            return src == edge.src && dest == edge.dest && weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, weight);
        }
    }

    // Pair class used in priority queue for Prim's
    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;
        int parent;

        Pair(int v, int c, int p) {
            vertex = v;
            cost = c;
            parent = p;
        }

        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    // Modified Prim's algorithm that returns MST cost and populates mstEdges
    public static int primMST(ArrayList<Edge>[] graph, int n, ArrayList<Edge> mstEdges) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int totalCost = 0;

        pq.add(new Pair(0, 0, -1)); // Start at vertex 0

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            if (!visited[u]) {
                visited[u] = true;
                totalCost += current.cost;

                if (current.parent != -1) {
                    mstEdges.add(new Edge(current.parent, u, current.cost));
                }

                for (Edge e : graph[u]) {
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight, u));
                    }
                }
            }
        }

        // If not all vertices were visited, return -1 (graph not connected)
        for (boolean v : visited) {
            if (!v)
                return -1;
        }

        return totalCost;
    }

    // Find the second MST by removing each edge from the first MST and
    // recalculating
    public static int findSecondMST(ArrayList<Edge>[] graph, int n, ArrayList<Edge> mstEdges, int firstMSTCost) {
        int secondMSTCost = Integer.MAX_VALUE;

        for (Edge excludedEdge : mstEdges) {
            ArrayList<Edge>[] modifiedGraph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                modifiedGraph[i] = new ArrayList<>();
                for (Edge e : graph[i]) {
                    modifiedGraph[i].add(new Edge(e.src, e.dest, e.weight));
                }
            }

            // Remove the edge in both directions
            modifiedGraph[excludedEdge.src].remove(new Edge(excludedEdge.src, excludedEdge.dest, excludedEdge.weight));
            modifiedGraph[excludedEdge.dest].remove(new Edge(excludedEdge.dest, excludedEdge.src, excludedEdge.weight));

            ArrayList<Edge> tempMSTEdges = new ArrayList<>();
            int newCost = primMST(modifiedGraph, n, tempMSTEdges);

            if (newCost != -1 && newCost != firstMSTCost) {
                secondMSTCost = Math.min(secondMSTCost, newCost);
            }
        }

        if (secondMSTCost == Integer.MAX_VALUE) {
            return -1; // No second MST found
        } else {
            return secondMSTCost; // Return the cost of the second MST
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt(); // Number of vertices

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt(); // Number of edges

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter each edge in the format: source destination weight");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        ArrayList<Edge> mstEdges = new ArrayList<>();
        int firstMSTCost = primMST(graph, n, mstEdges);

        if (firstMSTCost == -1) {
            System.out.println("The graph is not connected. MST not possible.");
            return;
        }

        System.out.println("Cost of First MST: " + firstMSTCost);

        int secondMSTCost = findSecondMST(graph, n, mstEdges, firstMSTCost);
        if (secondMSTCost == -1) {
            System.out.println("No Second Minimum Spanning Tree exists.");
        } else {
            System.out.println("Cost of Second MST: " + secondMSTCost);
        }
    }
}
