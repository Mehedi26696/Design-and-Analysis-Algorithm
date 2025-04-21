
# Graph Variations


## Connected Graph

A connected graph is a type of graph in which there is a path between every pair of vertices. This means that there are no isolated vertices, and it is possible to traverse from any vertex to any other vertex within the graph.

### Properties of Connected Graphs

- **Path Existence**: There is at least one path connecting any two vertices.
- **Single Component**: The graph consists of a single connected component.
- **No Isolated Vertices**: All vertices are part of the graph's structure.

### Examples

1. **Simple Connected Graph**:
    ```
    A -- B
    |    |
    C -- D
    ```

2. **Connected Graph with More Vertices**:
    ```
    A -- B -- E
    |    |
    C -- D
    ```

### Applications

- **Network Design**: Ensuring all nodes in a network are reachable.
- **Social Networks**: Analyzing connectivity between individuals.
- **Transportation Systems**: Designing routes that connect all locations.


## Directed and Undirected Graphs

Graphs can be classified into two main types based on the direction of edges: directed graphs and undirected graphs.

### Directed Graph (Digraph)

A directed graph, or digraph, is a graph in which the edges have a direction. This means that each edge is an ordered pair of vertices, indicating a one-way relationship between the vertices.

#### Properties of Directed Graphs

- **Directed Edges**: Each edge has a direction, represented as an arrow from one vertex to another.
- **Asymmetry**: The relationship between vertices is not necessarily reciprocal.
- **In-Degree and Out-Degree**: Each vertex has an in-degree (number of incoming edges) and an out-degree (number of outgoing edges).

#### Examples

1. **Simple Directed Graph**:
    ```
    A → B
    ↑    ↓
    C ← D
    ```

2. **Directed Graph with More Vertices**:
    ```
    A → B → E
    ↑    ↓
    C ← D
    ```

#### Applications

- **Web Page Ranking**: Representing links between web pages.
- **Task Scheduling**: Modeling dependencies between tasks.
- **Navigation Systems**: Representing one-way streets.

### Undirected Graph

An undirected graph is a graph in which the edges have no direction. This means that each edge is an unordered pair of vertices, indicating a bidirectional relationship between the vertices.

#### Properties of Undirected Graphs

- **Undirected Edges**: Each edge is bidirectional, with no specific direction.
- **Symmetry**: The relationship between vertices is reciprocal.
- **Degree**: Each vertex has a degree, which is the number of edges connected to it.

#### Examples

1. **Simple Undirected Graph**:
    ```
    A -- B
    |    |
    C -- D
    ```

2. **Undirected Graph with More Vertices**:
    ```
    A -- B -- E
    |    |
    C -- D
    ```

#### Applications

- **Social Networks**: Representing friendships or connections.
- **Biological Networks**: Modeling interactions between proteins or genes.
- **Infrastructure Networks**: Representing utilities like water or electricity grids.


## Weighted Graph

A weighted graph is a type of graph in which each edge has an associated numerical value, called a weight. These weights can represent various quantities such as distances, costs, or capacities, depending on the context in which the graph is used.

### Properties of Weighted Graphs

- **Edge Weights**: Each edge has a numerical value associated with it.
- **Path Cost**: The cost of a path is the sum of the weights of the edges in the path.
- **Optimization Problems**: Weighted graphs are often used to solve optimization problems like finding the shortest path or the minimum spanning tree.

### Examples

1. **Simple Weighted Graph**:
    ```
    A --2-- B
    |      |
    3      1
    |      |
    C --4-- D
    ```

2. **Weighted Graph with More Vertices**:
    ```
    A --2-- B --3-- E
    |      |
    3      1
    |      |
    C --4-- D
    ```

### Applications

- **Shortest Path Algorithms**: Finding the shortest path between two vertices (e.g., Dijkstra's algorithm).
- **Network Routing**: Optimizing data transfer routes in a network.
- **Resource Allocation**: Modeling and optimizing resource distribution in various systems.


## Multigraph

A multigraph is a type of graph in which multiple edges (also called parallel edges) between the same pair of vertices are allowed. This means that there can be more than one edge connecting any two vertices.

### Properties of Multigraphs

- **Multiple Edges**: There can be more than one edge between any pair of vertices.
- **Loops**: Multigraphs can also contain loops, which are edges that connect a vertex to itself.
- **Edge Multiplicity**: The number of edges between any two vertices is called the edge multiplicity.

### Examples

1. **Simple Multigraph**:
    ```
    A == B
    ||   |
    C == D
    ```

2. **Multigraph with Loops**:
    ```
    A == B
    ||   |
    C == D
    |    |
    D -- D
    ```

### Applications

- **Transportation Networks**: Modeling multiple routes between locations.
- **Communication Networks**: Representing multiple communication channels between nodes.
- **Biological Networks**: Modeling multiple interactions between biological entities.



## Path, Path Length, and Cycle

### Path

A path in a graph is a sequence of vertices connected by edges. In a directed graph, the direction of the edges must be followed.

#### Properties of Paths

- **Sequence of Vertices**: A path is defined by an ordered sequence of vertices.
- **Edge Connectivity**: Each consecutive pair of vertices in the sequence is connected by an edge.
- **No Repeated Edges**: A simple path does not repeat any edges.

#### Examples

1. **Simple Path**:
    ```
    A → B → C
    ```

2. **Path in an Undirected Graph**:
    ```
    A -- B -- C
    ```

### Path Length

The length of a path is the number of edges in the path. In a weighted graph, the path length can also refer to the sum of the weights of the edges in the path.

#### Examples

1. **Path Length in an Unweighted Graph**:
    ```
    A → B → C
    Path Length: 2
    ```

2. **Path Length in a Weighted Graph**:
    ```
    A --2-- B --3-- C
    Path Length: 2 (unweighted), 5 (weighted)
    ```

### Cycle

A cycle in a graph is a path that starts and ends at the same vertex, with no other repetitions of vertices and edges.

#### Properties of Cycles

- **Closed Path**: A cycle is a path that starts and ends at the same vertex.
- **No Repeated Vertices**: Except for the starting and ending vertex, no other vertices are repeated.
- **No Repeated Edges**: Edges are not repeated in a simple cycle.

#### Examples

1. **Simple Cycle**:
    ```
    A → B → C → A
    ```

2. **Cycle in an Undirected Graph**:
    ```
    A -- B -- C -- A
    ```

### Applications

- **Network Design**: Detecting cycles to avoid routing loops.
- **Graph Algorithms**: Used in algorithms like detecting strongly connected components.
- **Biological Networks**: Analyzing feedback loops in biological systems.


## Degree of a Vertex

The degree of a vertex in a graph is the number of edges connected to it. In the case of directed graphs, we distinguish between in-degree and out-degree.

### Types of Degree

- **Degree (Undirected Graph)**: The number of edges connected to a vertex.
- **In-Degree (Directed Graph)**: The number of incoming edges to a vertex.
- **Out-Degree (Directed Graph)**: The number of outgoing edges from a vertex.

### Properties

- **Sum of Degrees**: In an undirected graph, the sum of the degrees of all vertices is twice the number of edges.
- **Degree Sequence**: A list of vertex degrees, usually in non-increasing order.

### Examples

1. **Degree in an Undirected Graph**:
    ```
    A -- B
    |    |
    C -- D
    ```
    - Degree of A: 2
    - Degree of B: 2
    - Degree of C: 2
    - Degree of D: 2

2. **In-Degree and Out-Degree in a Directed Graph**:
    ```
    A → B
    ↑    ↓
    C ← D
    ```
    - In-Degree of A: 1, Out-Degree of A: 1
    - In-Degree of B: 1, Out-Degree of B: 1
    - In-Degree of C: 1, Out-Degree of C: 1
    - In-Degree of D: 1, Out-Degree of D: 1

### Applications

- **Graph Traversal**: Used in algorithms like BFS and DFS.
- **Network Analysis**: Understanding connectivity and influence in networks.
- **Graph Coloring**: Helps in determining the chromatic number of a graph.


## Negative Weight Cycle

A negative weight cycle in a graph is a cycle whose total weight (sum of the edge weights) is negative. Negative weight cycles are significant in the context of shortest path algorithms, as they can lead to undefined behavior or incorrect results.

### Properties of Negative Weight Cycles

- **Negative Total Weight**: The sum of the weights of the edges in the cycle is negative.
- **Cycle**: It forms a closed loop, starting and ending at the same vertex.
- **Impact on Shortest Paths**: Presence of a negative weight cycle can make it impossible to find the shortest path, as repeatedly traversing the cycle can reduce the path cost indefinitely.

### Examples

1. **Simple Negative Weight Cycle**:
    ```
    A --(-1)--> B
    ^          |
    |          v
    +----(-2)--+
    ```

2. **Negative Weight Cycle in a Larger Graph**:
    ```
    A --1--> B --2--> C
    ^                 |
    |                 v
    +----(-4)---------+
    ```

### Applications

- **Shortest Path Algorithms**: Detecting negative weight cycles is crucial in algorithms like the Bellman-Ford algorithm.
- **Financial Modeling**: Identifying arbitrage opportunities in currency exchange graphs.
- **Network Optimization**: Ensuring stability and correctness in network routing protocols.



## Complete Graph

A complete graph is a type of graph in which there is an edge between every pair of vertices. This means that every vertex is directly connected to every other vertex in the graph.

### Properties of Complete Graphs

- **Maximum Edges**: A complete graph with \( n \) vertices has \( \frac{n(n-1)}{2} \) edges.
- **Highly Connected**: Every vertex is connected to every other vertex.
- **Symmetric**: The graph is symmetric, meaning the structure looks the same from any vertex.

### Examples

1. **Complete Graph with 3 Vertices (K3)**:
    ```
    A -- B
    | \/ |
    | /\ |
    C -- D
    ```

### Applications

- **Network Design**: Ensuring maximum connectivity in network topologies.
- **Social Networks**: Modeling scenarios where everyone knows everyone else.
- **Graph Theory**: Studying properties and algorithms related to highly connected graphs.



## Bipartite Graph

A bipartite graph is a type of graph in which the vertices can be divided into two disjoint sets such that no two vertices within the same set are adjacent. This means that every edge connects a vertex in one set to a vertex in the other set.

### Properties of Bipartite Graphs

- **Two Sets of Vertices**: The vertex set can be divided into two disjoint sets \( U \) and \( V \).
- **No Intra-Set Edges**: There are no edges between vertices within the same set.
- **Bipartition**: The graph can be colored using two colors such that no two adjacent vertices share the same color.

### Examples

1. **Simple Bipartite Graph**:
    ```
    U: {A, C}
    V: {B, D}
    A -- B
    C -- D
    ```

2. **Bipartite Graph with More Vertices**:
    ```
    U: {A, C, E}
    V: {B, D, F}
    A -- B
    C -- D
    E -- F
    ```

### Applications

- **Matching Problems**: Used in problems like job assignments, where jobs and applicants can be represented as two sets of vertices.
- **Network Flow**: Modeling and solving network flow problems.
- **Graph Coloring**: Determining if a graph is bipartite helps in graph coloring problems.

