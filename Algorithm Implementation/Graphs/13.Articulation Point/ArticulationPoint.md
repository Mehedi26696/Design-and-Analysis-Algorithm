
# Articulation Points in Graphs

## What are Articulation Points?
An **articulation point** (or cut vertex) in a graph is a vertex that, when removed along with its associated edges, increases the number of connected components in the graph. These points are critical for maintaining the connectivity of the graph.

## Applications
- Network design: Identifying critical nodes in communication networks.
- Social networks: Finding influential individuals.
- Biology: Analyzing protein interaction networks.

## Algorithm to Find Articulation Points
The most common approach to finding articulation points is using **Depth First Search (DFS)**. Below are the steps:

### 1. Definitions
- **Discovery Time (`disc[]`)**: The time when a vertex is first visited during DFS.
- **Lowest Time (`low[]`)**: The smallest discovery time reachable from the vertex, including its subtree and back edges.
- **Parent (`parent[]`)**: Tracks the parent of each vertex in the DFS tree.

### 2. Steps
1. Initialize:
    - `disc[]` and `low[]` to `-1` for all vertices.
    - `parent[]` to `-1` for all vertices.
    - A boolean array `articulation[]` to mark articulation points.

2. Perform DFS:
    - For each unvisited vertex, call the recursive DFS function.
    - Update `disc[]` and `low[]` for each vertex.

3. Check Articulation Conditions:
    - **Root Node**: If the root of the DFS tree has two or more children, it is an articulation point.
    - **Non-root Node**: A vertex `u` is an articulation point if there exists a child `v` such that `low[v] >= disc[u]`.


```java

import java.util.ArrayList;

public class ArticulationPoint {

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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    // Function to find articulation points in the graph

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int disc[], int low[], int time,
            boolean visited[], boolean isArticulation[]) {

        visited[curr] = true; // mark the current node as visited
        disc[curr] = low[curr] = ++time; // set the discovery time and low value of the current node

        int children = 0; // to count the number of children of the current node

        for (Edge edge : graph[curr]) {
            int neigh = edge.dest;

            if (neigh == par) {
                continue; // if the neighbour is the parent of the current node, skip it
            } else if (!visited[neigh]) {
                dfs(graph, neigh, curr, disc, low, time, visited, isArticulation); // if the neighbour is not visited, call dfs on it
                low[curr] = Math.min(low[curr], low[neigh]); // update the low value of the current node
                // if the lowest discovery time of the neighbour is greater than or equal to the discovery time of the current node,

                if (par != -1 && disc[curr] <= low[neigh]) {

                    isArticulation[curr] = true; // if the current node is not the root node and the discovery time of the current node is less than or equal to
                    // the lowest discovery time of the neighbour, then the current node is an articulation point
                }

                children++; // increment the number of children of the current node

            } else {
                low[curr] = Math.min(low[curr], disc[neigh]); // if the neighbour is already visited, update the low value of the current node
            }
        }

        if (par == -1 && children > 1) {
            isArticulation[curr] = true;  // if the current node is the root node and it has more than one child, then the current node is an articulation point
        }

    }

    public static void getArticulationPoints(ArrayList<Edge> graph[], int V) {

        int disc[] = new int[V]; // discovery time of the node

        int low[] = new int[V]; // lowest discovery time of the node

        int time = 0;

        boolean visited[] = new boolean[V];

        boolean isArticulation[] = new boolean[V]; // to check if the node is an articulation point
        // initially all nodes are not articulation points

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                dfs(graph, i, -1, disc, low, time, visited,isArticulation); // -1 is the parent of the root node
                // in the first call of dfs, there is no parent so we pass -1

            }
        }

        System.out.println("Articulation points in the graph are: ");
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int V = 5; // number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // printing the graph
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }

        getArticulationPoints(graph, V);



    }
}
```

### 4. Complexity
- **Time Complexity**: `O(V + E)` where `V` is the number of vertices and `E` is the number of edges.
- **Space Complexity**: `O(V)` for arrays like `disc[]`, `low[]`, and `parent[]`.



## Key Points
- Articulation points are crucial for graph connectivity.
- DFS-based algorithms are efficient for finding them.
- Ensure proper initialization of arrays to avoid errors.
