import java.util.ArrayList;
import java.util.Scanner;

public class Floyd_Warshall_Algo2 {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int INF = 99999;

    public static void floydWarshall(int dist[][], int V) {

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = sc.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter the number of edges:");
        int E = sc.nextInt(); // Number of edges

        System.out.println("Enter the edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            graph[source].add(new Edge(source, destination, weight));
        }

        int dist[][] = new int[V][V];

        // Initialize the distance matrix with INF values
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // Fill the distance matrix with edge weights
        for (int i = 0; i < V; i++) {
            for (Edge edge : graph[i]) {
                dist[edge.source][edge.destination] = edge.weight;
            }
        }

        // Call the Floyd-Warshall algorithm

        floydWarshall(dist, V);

        // Print the shortest distance matrix
        System.out.println("Shortest distance matrix:");

        // Print the shortest distance matrix
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Shortest distance from source to destination:");
        int source = sc.nextInt();
        int destination = sc.nextInt();

        if (dist[source][destination] == INF) {
            System.out.println("No path exists from " + source + " to " + destination);
        } else {
            System.out.println(
                    "Shortest distance from " + source + " to " + destination + " is: " + dist[source][destination]);
        }

        sc.close();

    }
}
