import java.util.ArrayList;
import java.util.Stack;

public class SCC_Kosaraju_Algorithm {

    static class Edge {

        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], int node, boolean visited[], Stack<Integer> stack) {

        visited[node] = true;

        for (Edge edge : graph[node]) {
            if (!visited[edge.dest]) {
                topSort(graph, edge.dest, visited, stack);
            }
        }

        stack.push(node);
    }

    public static void dfs(ArrayList<Edge> graph[], int node, boolean visited[]) {

        visited[node] = true;
        System.out.print(node + " ");

        for (Edge edge : graph[node]) {
            if (!visited[edge.dest]) {
                dfs(graph, edge.dest, visited);
            }
        }

    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {

        // Step 1: Topological Sort using DFS and fill the stack

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false; // Reset visited for the next DFS
            transposeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (Edge edge : graph[i]) {
                transposeGraph[edge.dest].add(new Edge(edge.dest, edge.src)); // Reverse the edge direction
            }
        }

        // Step 3: DFS on the transposed graph in the order of the stack

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                // Perform DFS on the transposed graph
                System.out.print("SCC: ");
                dfs(transposeGraph, node, visited);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // printing the graph
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }

        System.out.println("SCCs in the given graph are: ");
        kosaraju(graph, V);

    }
}
