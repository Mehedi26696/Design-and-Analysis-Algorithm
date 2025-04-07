
import java.util.*;

public class NeighbourOfNode {

    public int v;
    public List<List<Integer>> adjList;

    public NeighbourOfNode(int v) {
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

    public void printneighbour(int i) {
        System.out.print(i + " -> ");
        for (int j : adjList.get(i)) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
       
        NeighbourOfNode g = new  NeighbourOfNode(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Adjacency List of the graph:");
        g.print();  

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the node to find its neighbours: ");
        int node = sc.nextInt();
        if (node >= 0 && node < g.v) {
            System.out.println("Neighbours of node " + node + ":");
            g.printneighbour(node);
        } else {
            System.out.println("Invalid node number.");
        }
        sc.close();

        
    }
}
