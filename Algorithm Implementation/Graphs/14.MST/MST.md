# Minimum Spanning Tree (MST)

A **Minimum Spanning Tree (MST)** is a subset of edges in a connected, weighted, and undirected graph that connects all vertices without forming cycles and with the minimum total edge weight.

## Key Concepts

- **Spanning Tree**: A subgraph that includes all vertices of the graph and forms a single connected tree.
- **Minimum Spanning Tree**: The spanning tree with the smallest total edge weight among all possible spanning trees.

## Applications

- **Network Design**: Used in designing computer networks, telecommunication networks, and road networks.
- **Approximation Algorithms**: Helps solve problems like the Traveling Salesman Problem (TSP).
- **Clustering**: Applied in hierarchical clustering algorithms.

## Common Algorithms to Find MST

1. **Kruskal's Algorithm**:
    - Sort edges by weight in non-decreasing order.
    - Add edges to the MST while avoiding cycles.
    - Uses Disjoint Set Union (DSU) for cycle detection.

2. **Prim's Algorithm**:
    - Start with an arbitrary vertex.
    - Grow the MST by adding the smallest edge connecting a vertex in the MST to one outside it.
    - Efficiently implemented using a priority queue (min-heap).

3. **Borůvka's Algorithm**:
    - Add the smallest edge from each component repeatedly until only one component remains.
    - Suitable for parallel or distributed computing.

## Properties

- A graph can have multiple MSTs if edges have the same weight.
- The MST is unique if all edge weights are distinct.
- An MST of a graph with `V` vertices always has `V-1` edges.

## Complexity

- **Kruskal's Algorithm**: O(E log E) or O(E log V) (with Union-Find).
- **Prim's Algorithm**: O(E + V log V) (with a priority queue).
- **Borůvka's Algorithm**: O(E log V).

## Constraints

- The graph must be connected; otherwise, an MST cannot be formed.
- The graph must be undirected.

## Example Use Case

Imagine connecting cities with the minimum cost of laying cables. Cities are vertices, and cable costs are edge weights. Finding the MST provides the optimal way to connect all cities with the least total cost.
