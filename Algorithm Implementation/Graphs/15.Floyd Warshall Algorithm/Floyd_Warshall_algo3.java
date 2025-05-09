import java.util.Scanner;
import java.util.ArrayList;

public class Floyd_Warshall_algo3 {

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

        System.out.println("Enter the number of edges:");
        int E = sc.nextInt(); // Number

        int distance[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        System.out.println("Enter the edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            distance[source][destination] = weight;
        }

        // Call the Floyd-Warshall algorithm
        floydWarshall(distance, V);

        // Print the shortest distance matrix
        System.out.println("Shortest distance matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Shortest distance from source to destination:");

        int source = sc.nextInt();
        int destination = sc.nextInt();

        if (distance[source][destination] == INF) {
            System.out.println("No path exists from " + source + " to " + destination);
        } else {
            System.out.println("Shortest distance from " + source + " to " + destination + " is: "
                    + distance[source][destination]);
        }
        sc.close();
    }
}
