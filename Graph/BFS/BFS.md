
# Graph BFS (Breadth-First Search) in Java

## Introduction
Breadth-First Search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or an arbitrary node of a graph) and explores the neighbor nodes at the present depth prior to moving on to nodes at the next depth level.

## BFS using Adjacency List

### Adjacency List Representation
An adjacency list represents a graph as an array of lists. The index of the array represents a vertex, and each element in the list represents the other vertices that are connected to the vertex.

### Java Implementation

```java
import java.util.*;

public class AdjacencyListBFS {

    private int v;
    public List<List<Integer>> adjList;

    public AdjacencyListBFS(int v) {
        this.v = v;
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void removeEdge(int i, int j) {
        adjList.get(i).remove((Integer) j);
        adjList.get(j).remove((Integer) i);
    }

    public void bfs(int src) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (queue.size() != 0) {
            int element = queue.poll();
            System.out.print(element + " ");
            for (int i : adjList.get(element)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdjacencyListBFS g = new AdjacencyListBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println("Enter the source vertex for BFS traversal");
        int src = sc.nextInt();
        System.out.println("BFS Traversal from source vertex " + src + " is:");
        g.bfs(src);
        sc.close();
    }
}
```

## BFS using Adjacency Matrix

### Adjacency Matrix Representation
An adjacency matrix is a 2D array of size `V x V` where `V` is the number of vertices in a graph. A cell `adj[i][j]` is `1` if there is an edge from vertex `i` to vertex `j`, otherwise `0`.

### Java Implementation

```java
import java.util.*;

public class AdjacencyMatrixBFS {
    public int[][] adjMatrix;
    public int v;

    public AdjacencyMatrixBFS(int v) {
        this.v = v;
        adjMatrix = new int[v][v];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }
    public void bfs2(int src) {
        boolean[] visited = new boolean[v];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print(element + " ");
            for (int i = 0; i < v; i++) {
                if (adjMatrix[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdjacencyMatrixBFS g = new AdjacencyMatrixBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println("Enter the source vertex for BFS traversal");
        int src = sc.nextInt(); 

        System.out.println("BFS traversal of graph from vertex " + src + " is ");
      //  g.bfs(src);
        g.bfs2(src);
        sc.close();
    }
}

```

## Complexity Comparison

| Representation      | Space Complexity | Time Complexity (BFS) |
|---------------------|------------------|-----------------------|
| Adjacency List      | O(V + E)         | O(V + E)              |
| Adjacency Matrix    | O(V^2)           | O(V^2)                |

## Conclusion
Both adjacency list and adjacency matrix representations have their own advantages and disadvantages. The adjacency list is more space-efficient for sparse graphs, while the adjacency matrix allows for faster edge lookups. The choice of representation depends on the specific requirements of the application.

