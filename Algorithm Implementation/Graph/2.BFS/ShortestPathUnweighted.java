
import java.util.*;

public class ShortestPathUnweighted {
    public int[][] adjMatrix;
    public int v;

    public int[] color;
    public int[] parent;
    public int[] distance;

    public ShortestPathUnweighted(int v) {
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

    public void bfs(int src) {
        color = new int[v];
        parent = new int[v];
        distance = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = 0; // 0 for white
            parent[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        color[src] = 1; // 1 for gray
        parent[src] = -1;
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print(element + " ");
            for (int i = 0; i < v; i++) {
                if (adjMatrix[element][i] == 1 && color[i] == 0) {
                    queue.add(i);
                    color[i] = 1; // 1 for gray
                    parent[i] = element;
                    distance[i] = distance[element] + 1;
                }
            }
            color[element] = 2; // 2 for black
        }
    }

    void graphPrint() {
        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + i + " is connected to ");
            for (int j = 0; j < v; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    void colorPrint() {
        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + i + " is " + color[i]);
            if (color[i] == 0) {
                System.out.println(" (White)");
            } else if (color[i] == 1) {
                System.out.println(" (Gray)");
            } else {
                System.out.println(" (Black)");
            }
        }
    }

    void parentPrint() {
        for (int i = 0; i < v; i++) {
            System.out.println("Parent of " + i + " is " + parent[i]);
        }
    }

    void distancePrint() {
        for (int i = 0; i < v; i++) {
            System.out.println("Distance of " + i + " from source is " + distance[i]);
        }
    }

    void printPath(int src, int dest) {
        if (src == dest) {
            System.out.print(src);
        } else if (parent[dest] == -1) {
            System.out.println("No path from " + src + " to " + dest);
        } else {
            printPath(src, parent[dest]);
            System.out.print("->"+dest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShortestPathUnweighted g = new ShortestPathUnweighted(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Adjacency Matrix of graph is ");
        g.graphPrint();

        System.out.println("Enter the source vertex for BFS traversal");
        int src = sc.nextInt();

        System.out.println("BFS traversal of graph from vertex " + src + " is ");
        g.bfs(src);

        System.out.println("\nColor of vertices");
        g.colorPrint();

        System.out.println("\nParent of vertices");
        g.parentPrint();

        System.out.println("\nDistance of vertices from source vertex");
        g.distancePrint();

        System.out.println("\nEnter the destination vertex to find path from source vertex " + src);

        int dest = sc.nextInt();
        System.out.println("Shortest path from " + src + " to " + dest + " is ");
        g.printPath(src, dest);

        sc.close();
    }
}
