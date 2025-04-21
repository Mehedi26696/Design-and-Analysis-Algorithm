import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    public int v;
    public List<List<Integer>> adj;
    
    TopologicalSortUsingDFS(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Topological Sort using DFS
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        
        for (int n : adj.get(v)) {
            if (!visited[n]) {
                topologicalSortUtil(n, visited, stack);
            }
        }
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    

    public static void main(String args[]) {
        TopologicalSortUsingDFS g = new TopologicalSortUsingDFS(6);

        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);


        System.out.println("Following is a Topological Sort of the given graph:");
        g.topologicalSort();

        
    }
}
