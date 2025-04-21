
# Graph Representation

Graphs can be represented in two main ways: using an adjacency list and an adjacency matrix. Below are detailed notes on how to create graphs using both methods, along with Java implementations.

## Adjacency List

An adjacency list represents a graph as an array of lists. The array index represents a vertex, and each element in the list represents the other vertices that are connected to the vertex.

### Example Output

Here is an example of the adjacency list representation for a graph with 4 vertices:

```
0: 1 2
1: 0 2
2: 0 1 3
3: 2
```

### Java Implementation

```java
import java.util.*;

public class AdjacencyListGraph {

    public int v;
    public List<List<Integer>> adjList;

    public AdjacencyListGraph(int v) {
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

    public void print() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Adjacency List of the graph:");
        g.print();
    }
}
```

## Adjacency Matrix

An adjacency matrix represents a graph as a 2D array of integers. A cell `matrix[i][j]` is `1` if there is an edge from vertex `i` to vertex `j`, otherwise `0`.
### Example Output

Here is an example of the adjacency matrix representation for a graph with 4 vertices:

```
0 1 1 0
1 0 1 0
1 1 0 1
0 0 1 0
```


### Java Implementation

```java
public class AdjacencyMatrixGraph {
    public int[][] adjMatrix;
    public int v;

    public AdjacencyMatrixGraph(int v) {
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

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < v; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
```

## Complexity Comparison

| Representation     | Space Complexity | Add Edge | Remove Edge | Check if Edge Exists | Iterate over all edges |
|--------------------|------------------|----------|-------------|----------------------|------------------------|
| Adjacency List     | O(V + E)         | O(1)     | O(E)        | O(E)                 | O(V + E)               |
| Adjacency Matrix   | O(V^2)           | O(1)     | O(1)        | O(1)                 | O(V^2)                 |

## Summary

- **Adjacency List**: Efficient in terms of space for sparse graphs. Easy to iterate over all edges.
- **Adjacency Matrix**: Simple and efficient for dense graphs. Easy to check if there is an edge between two vertices.

