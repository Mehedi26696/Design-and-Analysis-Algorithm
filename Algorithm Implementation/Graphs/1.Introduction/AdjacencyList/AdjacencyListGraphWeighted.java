
/*     
       (5)
    0 ---- 1
          | \
       (1)|  \ (3)
         |    \ 
         2 ---- 3
         |  (1)
     (2) |
         |
         4

 */

import java.util.ArrayList;

public class AdjacencyListGraphWeighted {

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

    public static void main(String[] args) {

        int v = 5; // Number of vertices

        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex

        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

        // Print the adjacency list representation of the graph
        System.out.println("Adjacency List of the graph:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.dest + ", " + edge.weight + ") ");
            }
            System.out.println();
        }

        // Example of accessing the weight of an edge
        int src = 1, dest = 2;
        for (Edge edge : graph[src]) {
            if (edge.dest == dest) {
                System.out.println("Weight of edge from " + src + " to " + dest + " is: " + edge.weight);
                break;
            }
        }

        // Neighbors of vertex 1
        System.out.print("Neighbors of vertex 1: ");
        for (Edge edge : graph[1]) {
            System.out.print(edge.dest + " ");
        }
        System.out.println();

    }

}
