

// This code detects cycles in an undirected graph using Depth First Search (DFS).
import java.util.*;

public class BipartiteGraphByBFS {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int V = graph.length;
        int color[] = new int[V];

        Arrays.fill(color, -1); // Initialize all vertices as uncolored (-1)


        Queue<Integer> queue = new LinkedList<>();
         
        for(int i=0; i<graph.length; i++){
            if(color[i]==-1){ // If the vertex is uncolored
                // Start BFS from this vertex
                queue.add(i);
                color[i]=0; // Assign first color to the first vertex

                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(Edge edge: graph[node]){
                        if(color[edge.dest]==-1){ // If the destination vertex is uncolored
                            color[edge.dest] = 1 - color[node]; // Assign opposite color
                            queue.add(edge.dest);
                        }else if(color[edge.dest] == color[node]){ // If the destination vertex has the same color as the current vertex
                            return false; // Not bipartite
                        }
                    }
                }
            }
        }
        return true; // All vertices can be colored with two colors
    }
    

     

    public static void main(String[] args) {

        /*              0 -------- 2
                        /          /
                       /          /
                       1          4
                        \        /
                         \      /
                          \   /
                           3
                     



         */
        int V = 5; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        System.out.println("Graph is : ");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }

        if (isBipartite(graph)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
       
       
    }

}

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph. This is because we are visiting each vertex and edge once.
// Space Complexity: O(V) for the color array and the queue used in BFS.

// If a graph doesn't contain any cycles, it can be colored using two colors such that no two adjacent vertices have the same color. This is the definition of a bipartite graph.
// If cycles are not present in the graph, it is by default bipartite. However, if cycles are present, we need to check if they are even or odd.

// If the cycle is even(total number of edges/vertices in the cycle is even), then it is bipartite. If the cycle is odd, then it is not bipartite.