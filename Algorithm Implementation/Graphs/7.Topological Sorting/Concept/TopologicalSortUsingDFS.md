
# Topological Sort Using DFS

## Introduction
Topological Sort is a linear ordering of vertices in a directed acyclic graph (DAG) such that for every directed edge `u -> v`, vertex `u` comes before vertex `v` in the ordering. It is widely used in scenarios like task scheduling, dependency resolution, and more.

## Prerequisites
- **Directed Acyclic Graph (DAG):** Topological sorting is only possible for DAGs. If the graph contains cycles, topological sorting is not feasible.
- **Depth First Search (DFS):** One of the common approaches to implement topological sort is using DFS.

## Applications
1. Task scheduling with dependencies.
2. Resolving symbol dependencies in linkers.
3. Course prerequisite ordering in academic scheduling.

## Algorithm (Using DFS)
1. **Mark all vertices as unvisited.**
2. **Perform DFS for each unvisited vertex:**
    - Recursively visit all its adjacent vertices.
    - After visiting all adjacent vertices, push the current vertex onto a stack.
3. **Pop vertices from the stack to get the topological order.**

## Steps
1. Create an adjacency list for the graph.
2. Maintain a visited array to track visited nodes.
3. Use a stack to store the topological order.
4. Perform DFS and push nodes to the stack after visiting all their neighbors.
5. Reverse the stack to get the topological order.

## Implementation (Java)
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public int v;
    public List<List<Integer>> adj;
    
    TopologicalSort(int v) {
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
        TopologicalSort g = new TopologicalSort(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);


        System.out.println("Following is a Topological Sort of the given graph:");
        g.topologicalSort();

        
    }
}

```

## Complexity
- **Time Complexity:** `O(V + E)` where `V` is the number of vertices and `E` is the number of edges.
- **Space Complexity:** `O(V)` for the visited array and stack.

## Key Points
- Topological sort is not unique; multiple valid orders may exist.
- If the graph is not a DAG, the algorithm will fail to produce a valid order.
- Can also be implemented using Kahn's Algorithm (BFS-based approach).

## Example
### Input Graph
```
5 -> 2
5 -> 0
4 -> 0
4 -> 1
2 -> 3
3 -> 1
```

### Output
```
Topological Sort: [5, 4, 2, 3, 1, 0]
```
