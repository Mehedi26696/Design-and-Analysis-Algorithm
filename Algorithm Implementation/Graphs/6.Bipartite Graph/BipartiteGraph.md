
# Bipartite Graph

A **Bipartite Graph** is a type of graph where the set of vertices can be divided into two disjoint sets such that no two vertices within the same set are adjacent. In other words, all edges connect a vertex from one set to a vertex in the other set.

## Properties of Bipartite Graphs
1. A graph is bipartite if it is 2-colorable.
2. A graph is bipartite if it does not contain any odd-length cycles.
3. It can be represented as \( G = (U, V, E) \), where:
    - \( U \) and \( V \) are two disjoint sets of vertices.
    - \( E \) is the set of edges connecting vertices from \( U \) to \( V \).

## Applications of Bipartite Graphs
- Matching problems (e.g., job assignments, stable marriages).
- Network flow problems.
- Social network analysis.

---

## Algorithm to Check if a Graph is Bipartite
A common approach is to use **Breadth-First Search (BFS)** or **Depth-First Search (DFS)** to check if the graph can be colored using two colors.

### Steps:
1. Assign one color to the starting vertex.
2. Assign the opposite color to all its adjacent vertices.
3. Repeat the process for all vertices using BFS/DFS.
4. If a conflict arises (i.e., two adjacent vertices have the same color), the graph is not bipartite.

---

## Java Implementation

Below is a Java program to check if a graph is bipartite using BFS:

```java
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
```

### Explanation of the Code
1. **Graph Representation**: The graph is represented as an adjacency list using a 2D array.
2. **Color Array**: Keeps track of the color assigned to each vertex.
3. **BFS Traversal**: Ensures all connected components are checked for bipartite properties.
4. **Conflict Check**: If two adjacent vertices have the same color, the graph is not bipartite.

---

## Example Input and Output

### Input:
Graph represented as:
```
0 -- 1
|    |
3 -- 2
```
Adjacency List:
```java
int[][] graph = {
     {1, 3},
     {0, 2},
     {1, 3},
     {0, 2}
};
```

### Output:
```
The graph is Bipartite.
```

---

## Key Takeaways
- Bipartite graphs are useful in solving many real-world problems.
- BFS or DFS can efficiently determine if a graph is bipartite.
- Always check for disconnected components in the graph.
