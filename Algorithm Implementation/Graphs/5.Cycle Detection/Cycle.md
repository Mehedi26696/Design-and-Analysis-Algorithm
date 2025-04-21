
Key Notes:
- The algorithm can be applied to both directed and undirected graphs.
- For directed graphs, Depth-First Search (DFS) is commonly used to detect back edges, which indicate cycles.
- For undirected graphs, DFS can also be used, but care must be taken to distinguish between a back edge and a parent edge.
- In weighted graphs, cycle detection is typically used in conjunction with algorithms like Bellman-Ford to detect negative weight cycles.
- Applications of cycle detection include deadlock detection in operating systems, dependency resolution in package managers, and circuit analysis in electrical engineering.

Common Techniques:
1. Depth-First Search (DFS):
    - Mark nodes as visited during traversal.
    - For directed graphs, check for back edges.
    - For undirected graphs, ensure the edge does not lead back to the immediate parent.

2. Union-Find (Disjoint Set Union):
    - Used for cycle detection in undirected graphs.
    - Tracks connected components and detects cycles when two vertices in the same component are connected.

3. Topological Sorting:
    - Used for cycle detection in Directed Acyclic Graphs (DAGs).
    - If a topological sort is not possible, the graph contains a cycle.

Complexity:
- Time Complexity: O(V + E) for DFS-based methods, where V is the number of vertices and E is the number of edges.
- Space Complexity: O(V) for visited and recursion stack in DFS.

Limitations:
- The algorithm's efficiency depends on the graph representation (adjacency list or matrix).
- For large graphs, memory usage can become a concern due to recursion stack or auxiliary data structures.