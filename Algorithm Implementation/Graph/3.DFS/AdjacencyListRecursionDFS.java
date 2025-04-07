 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class AdjacencyListRecursionDFS {

    public int v;
    public List<List<Integer>> adj;

    AdjacencyListRecursionDFS(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void DFSUtil(int src, boolean visited[]) {
        visited[src] = true;
        System.out.print(src + " ");

        for (int n : adj.get(src)) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int src) {
        boolean visited[] = new boolean[v];
        DFSUtil(src, visited);
    }

    public static void main(String[] args) {
        AdjacencyListRecursionDFS g = new AdjacencyListRecursionDFS(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
        g.DFS(0);
    }
    
}
