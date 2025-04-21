
# Kosaraju's Algorithm and Strongly Connected Components (SCC)

## Introduction
Kosaraju's Algorithm is a graph traversal technique used to find all Strongly Connected Components (SCCs) in a directed graph. An SCC is a maximal subgraph where every vertex is reachable from every other vertex within the subgraph.

## Key Concepts
1. **Directed Graph**: A graph where edges have a direction.
2. **Strongly Connected Component (SCC)**: A subgraph where for every pair of vertices `u` and `v`, there exists a path from `u` to `v` and a path from `v` to `u`.

## Steps in Kosaraju's Algorithm
Kosaraju's Algorithm works in two main passes:

### Step 1: Perform a Topological Sort
1. Create an empty stack to store the vertices.
2. Perform a Depth First Search (DFS) on the original graph.
3. Push each vertex onto the stack after finishing its DFS call (post-order traversal).

### Step 2: Transpose the Graph
1. Reverse the direction of all edges in the graph to create the **transpose graph**.

### Step 3: Process Vertices in Stack Order
1. Initialize a visited set to keep track of visited nodes.
2. Pop vertices one by one from the stack.
3. For each popped vertex, perform a DFS on the transpose graph if it is not visited.
4. Each DFS traversal in this step identifies one SCC.

## Pseudocode
```java
import java.util.ArrayList;
import java.util.Stack;

public class SCC_Kosaraju_Algorithm {

    static class Edge {

        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], int node, boolean visited[], Stack<Integer> stack) {

        visited[node] = true;

        for (Edge edge : graph[node]) {
            if (!visited[edge.dest]) {
                topSort(graph, edge.dest, visited, stack);
            }
        }

        stack.push(node);
    }

    public static void dfs(ArrayList<Edge> graph[], int node, boolean visited[]) {

        visited[node] = true;
        System.out.print(node + " ");

        for (Edge edge : graph[node]) {
            if (!visited[edge.dest]) {
                dfs(graph, edge.dest, visited);
            }
        }

    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {

        // Step 1: Topological Sort using DFS and fill the stack

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false; // Reset visited for the next DFS
            transposeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (Edge edge : graph[i]) {
                transposeGraph[edge.dest].add(new Edge(edge.dest, edge.src)); // Reverse the edge direction
            }
        }

        // Step 3: DFS on the transposed graph in the order of the stack

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                // Perform DFS on the transposed graph
                System.out.print("SCC: ");
                dfs(transposeGraph, node, visited);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // printing the graph
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }

        System.out.println("SCCs in the given graph are: ");
        kosaraju(graph, V);

    }
}

```

## Complexity
- **Time Complexity**: `O(V + E)` where `V` is the number of vertices and `E` is the number of edges.
- **Space Complexity**: `O(V)` for the stack and visited set.

 
## Applications
1. **Web Crawling**: Identify clusters of interconnected web pages.
2. **Social Networks**: Detect communities or groups.
3. **Deadlock Detection**: Find cycles in resource allocation graphs.
4. **Compiler Design**: Optimize interdependent code blocks.

Kosaraju's Algorithm is simple yet powerful for solving SCC problems efficiently.