import java.lang.reflect.Array;
import java.util.*;

public class BFS {

    static class Edge {

        int src,dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
         
    }

    

    public static void bfs(ArrayList<Edge>graph[],int src){
        boolean [] visited = new boolean[graph.length];
        int [] distance = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            distance[i] = -1;
        }

 
         Queue<Integer> q = new LinkedList<>();

        q.add(src);

        visited[src] = true;
        distance[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Edge e : graph[curr]) {
                 
                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                    distance[e.dest] = distance[curr] + 1;
                }
            }
        }
        System.out.println();
        System.out.println("Distance from source " + src + ": ");
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src)); // For undirected graph
        }
        int start = sc.nextInt();

        bfs(graph, start);
    }

}
