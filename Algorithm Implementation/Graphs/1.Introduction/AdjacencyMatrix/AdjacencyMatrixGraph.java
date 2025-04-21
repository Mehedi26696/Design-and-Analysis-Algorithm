
 

public class AdjacencyMatrixGraph {
    public int[][] adjMatrix;
    public int v;

    public AdjacencyMatrixGraph(int v) {
        this.v = v;
        adjMatrix = new int[v][v];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

     public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < v; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

     
    public static void main(String[] args) {
      
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();

        
    }
}