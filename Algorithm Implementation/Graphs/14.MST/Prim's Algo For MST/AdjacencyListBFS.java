import java.util.*;

class Edge implements Comparable<Edge> {
    int dest, weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class AdjacencyListBFS {

    private int v;
    public List<List<Edge>> adjList;

    public AdjacencyListBFS(int v) {
        this.v = v;
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int i, int j, int weight) {
        adjList.get(i).add(new Edge(j, weight));
        adjList.get(j).add(new Edge(i, weight));
    }

    public void primMST() {
        boolean[] visited = new boolean[v];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int start = 0; // Starting vertex
        visited[start] = true;

        // Add all edges from the start vertex to the priority queue
        for (Edge edge : adjList.get(start)) {
            pq.add(edge);
        }

        int mstWeight = 0;
        System.out.println("Edges in the MST:");

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!visited[edge.dest]) {
                visited[edge.dest] = true;
                mstWeight += edge.weight;
                System.out.println("Edge: " + edge.dest + " Weight: " + edge.weight);

                // Add all edges from the current vertex to the priority queue
                for (Edge nextEdge : adjList.get(edge.dest)) {
                    if (!visited[nextEdge.dest]) {
                        pq.add(nextEdge);
                    }
                }
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        AdjacencyListBFS g = new AdjacencyListBFS(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);

        g.primMST();
    }
}

