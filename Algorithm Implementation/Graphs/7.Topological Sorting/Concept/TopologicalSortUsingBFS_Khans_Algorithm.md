
 
Khan's Algorithm (Topological Sorting):
----------------------------------------
Khan's algorithm is used to perform a topological sort on a Directed Acyclic Graph (DAG). 
It determines a linear ordering of vertices such that for every directed edge (u, v), 
vertex 'u' comes before vertex 'v' in the ordering.

Steps of Khan's Algorithm:
1. Compute the in-degree (number of incoming edges) for each vertex in the graph.
2. Initialize a queue and enqueue all vertices with in-degree of 0 (no dependencies).
3. While the queue is not empty:
    a. Dequeue a vertex from the queue and add it to the topological order.
    b. For each outgoing edge from the dequeued vertex, reduce the in-degree of the target vertex by 1.
    c. If the in-degree of a target vertex becomes 0, enqueue it.
4. If the topological order contains all vertices, the graph is a DAG, and the order is valid.
    Otherwise, the graph contains a cycle, and topological sorting is not possible.

Key Notes:
- The algorithm ensures that vertices with no dependencies are processed first.
- It is efficient with a time complexity of O(V + E), where V is the number of vertices and E is the number of edges.
- The algorithm is commonly used in scenarios such as task scheduling, build systems, and resolving dependencies.

Limitations:
- Khan's algorithm only works on Directed Acyclic Graphs (DAGs). If the graph contains cycles, it cannot produce a valid topological order.

Code Implementation in Java:
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS_Khans_Algorithm {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example edges
   
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void calcIndegree(ArrayList<Edge> graph[], int inDegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                inDegree[edge.dest]++;
            }
        }
    }
   

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        // Step 1: Calculate in-degrees of all vertices
         // Step 2: Initialize a queue and add all vertices with in-degree 0
         // Step 3: While the queue is not empty, do the following:
         // a. Remove a vertex from the queue and print it
         // b. For each of its neighbors, decrease their in-degree by 1
         // c. If any neighbor's in-degree becomes 0, add it to the queue
       

        // Step 1: Calculate in-degrees of all vertices

        int[] inDegree = new int[graph.length];
        calcIndegree(graph, inDegree);

        Queue<Integer> queue = new LinkedList<>();
        // Step 2: Initialize a queue and add all vertices with in-degree 0

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: While the queue is not empty, do the following:
        // a. Remove a vertex from the queue and print it
        // b. For each of its neighbors, decrease their in-degree by 1
        // c. If any neighbor's in-degree becomes 0, add it to the queue

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : graph[current]) {
                inDegree[edge.dest]--;
                if (inDegree[edge.dest] == 0) {
                    queue.add(edge.dest);
                }
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // print the graph

        System.out.println("Graph:");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
        // Perform topological sort using BFS (Khan's Algorithm)
        System.out.println("Topological Sort using BFS (Khan's Algorithm):");
        topologicalSort(graph);
    }
    
}

```
 