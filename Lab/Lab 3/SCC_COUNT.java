
// 1-indexed based
import java.util.*;

public class SCC_COUNT {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

    }

    public static void topsort(ArrayList<Edge> graph[], boolean[] visited, Stack<Integer> st, int curr) {

        visited[curr] = true;

        for (Edge e : graph[curr]) {

            if (!visited[e.dest]) {

                topsort(graph, visited, st, e.dest);

            }

        }

        st.push(curr);

    }

    public static void dfs(ArrayList<Edge> transGraph[], boolean[] vis, int node) {

        vis[node] = true;

        System.out.print(node + " ");

        for (Edge e : transGraph[node]) {

           if (!vis[e.dest]) {

            dfs(transGraph, vis, e.dest);
            
           }

        }
    }

    public static void SCC(ArrayList<Edge> graph[]) {

        boolean[] visited = new boolean[graph.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 1; i < graph.length; i++) {

            if (!visited[i]) {

                topsort(graph, visited, st, i);

            }

        }

        ArrayList<Edge> transGraph[] = new ArrayList[graph.length];

        for (int i = 1; i < transGraph.length; i++) {

            transGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i < graph.length; i++) {

            for (Edge e : graph[i]) {

                transGraph[e.dest].add(new Edge(e.dest, i));
            }

        }

        boolean[] vis = new boolean[transGraph.length];

        int count = 0;

        while (!st.isEmpty()) {

            int node = st.pop();

            if (!vis[node]) {

                System.out.print("SCC: ");
                dfs(transGraph, vis, node);
                System.out.println();
                count++;

            }

        }

        System.out.println(count);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();

        int E = sc.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[V + 1];


        for (int i = 1; i < graph.length; i++) {

            graph[i] = new ArrayList<>();

        }

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(new Edge(u, v));

        }

        SCC(graph);

    }
}