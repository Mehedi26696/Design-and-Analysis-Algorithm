
import java.util.*;
public class AdjacencyListStackDFS {
    
    public int v;
    public List<List<Integer>> adj;
    
    AdjacencyListStackDFS(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void DFS(int src) {
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        visited[src] = true;

        while (!stack.isEmpty()) {
            int s = stack.peek();
            stack.pop();
            System.out.print(s + " ");

            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        AdjacencyListStackDFS g = new AdjacencyListStackDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
        g.DFS(0);
    }
}