import java.util.ArrayList;

public class HasPath {
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

    // Function to check if a path exists between src and dest using DFS
    static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.dest]) {
                boolean pathFound = hasPath(graph, e.dest, dest, visited);
                if (pathFound) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean visited[] = new boolean[V];
        int src = 0;
        int dest = 5;
        boolean pathExists = hasPath(graph, src, dest, visited);
        System.out.println("Path exists from " + src + " to " + dest + ": " + pathExists);

        // Test with another source and destination
        src = 0;
        dest = 6;
        visited = new boolean[V]; // Reset visited array for new search
        pathExists = hasPath(graph, src, dest, visited);
        System.out.println("Path exists from " + src + " to " + dest + ": " + pathExists);

        src = 0;
        dest = 7; // Non-existent node
        visited = new boolean[V]; // Reset visited array for new search
        pathExists = hasPath(graph, src, dest, visited);
        System.out.println("Path exists from " + src + " to " + dest + ": " + pathExists);
    }
}
