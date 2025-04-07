import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    1---3
    /   |  \
   0    |   5 -- 6
    \   |   /
     2---4

 
 */

public class AdjacencyListDFSWeight {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -> 1, 2
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));

        // 1 -> 0,3
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 12));

        // 2 -> 0,4
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 4, 10));

        // 3 -> 1,4,5
        graph[3].add(new Edge(3, 1, 12));
        graph[3].add(new Edge(3, 4, 2));
        graph[3].add(new Edge(3, 5, 8));

        // 4 -> 2,3,5
        graph[4].add(new Edge(4, 2, 10));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // 5 -> 3,4,6
        graph[5].add(new Edge(5, 3, 8));
        graph[5].add(new Edge(5, 4, 5));
        graph[5].add(new Edge(5, 6, 3));

        // 6 -> 5
        graph[6].add(new Edge(6, 5, 3));
    }

    public static void print(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("[" + e.dest + ", " + e.weight + "] ");
            }
            System.out.println();
        }
    }


    // DFS traversal
    public static void dfs(ArrayList<Edge> graph[], int start, boolean visited[]) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Edge e = graph[start].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    

    public static void main(String[] args) {

        int V = 7; // number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        print(graph);
        System.out.println("DFS Traversal:");
        boolean visited[] = new boolean[V]; 
        dfs(graph, 0, visited);
        System.out.println();

        
        

    }

}
