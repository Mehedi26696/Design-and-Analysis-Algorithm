
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
       
        AdjacencyListGraph g = new  AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Adjacency List of the graph:");
        g.print();

        
    }
}
