

import java.util.*;

import java.io.*;

public class Topological{

    static class Edge{

        int src, dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, ArrayList<Edge> graph[]){

        visited[v] = true;

        for(Edge edge : graph[v]){
            if(!visited[edge.dest]){
                topologicalSortUtil(edge.dest, visited, stack, graph);
            }
        }

        stack.push(v);
    }

    public static void topologicalSort(ArrayList<Edge> graph[]){

        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack, graph);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void dfs(int v, boolean visited[], ArrayList<Edge> graph[]){

        visited[v] = true;
        System.out.print(v + " ");

        for(Edge edge : graph[v]){
            if(!visited[edge.dest]){
                dfs(edge.dest, visited, graph);
            }
        }
    }

    public static void dfsTraversal(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                dfs(i, visited, graph);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input.txt");

        Scanner sc = new Scanner(file);

        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src].add(new Edge(src, dest));
        }

        // print the graph
        System.out.println("Graph:");
        for(int i = 0; i < V; i++){
            System.out.print(i + " -> ");
            for(Edge edge : graph[i]){
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }

        // dfs

        System.out.println("DFS Traversal of the graph:");
        dfsTraversal(graph);

        System.out.println();


        System.out.println("Topological Sort of the given graph:");
        topologicalSort(graph);
    }
}