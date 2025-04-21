import java.util.ArrayList;

public class DirectedGraphCycleDetection {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

    }

    static void CreateGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));


        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length]; // To keep track of nodes in the recursion stack

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, i, visited, recStack)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle detected
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean recStack[]) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, e.dest, visited, recStack)) {
                    return true; // Cycle detected in the recursive call
                }
            } else if (recStack[e.dest]) {
                return true; // Cycle detected
            }
        }

        recStack[curr] = false; // Remove the node from recursion stack
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        // Print the graph
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge e : graph[i]) {
                System.out.print(" -> " + e.dest);
            }
            System.out.println();
        }
        // Detect cycle in the graph
        if (detectCycle(graph)) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
         
    }
}