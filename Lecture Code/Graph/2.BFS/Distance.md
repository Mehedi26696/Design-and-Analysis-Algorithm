# Distance Calculation in a Graph using BFS

## Introduction

Breadth-First Search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the source node and explores all of the neighbor nodes at the present depth prior to moving on to nodes at the next depth level.

## Steps to Calculate Distance from Source

1. **Initialize**:

   - Create a queue and enqueue the source node.
   - Create a distance array and initialize all distances to infinity (`∞`), except the source node which should be set to 0.

2. **BFS Traversal**:

   - Dequeue a node from the queue.
   - For each adjacent node, if it has not been visited, update its distance and enqueue it.

3. **Termination**:
   - The algorithm terminates when the queue is empty.

## Java Implementation

```java


 import java.util.*;

 public class  DistanceBFS {

     public int[][] adjmatrix;
     public int v;
     public int e;
     int count = 0;
     int [] distance;

     DistanceBFS(int v,int e){
         this.v = v;
         this.e = e;

         adjmatrix = new int[v+1][v+1];
     }

     public void add(int i,int j){
         adjmatrix[i][j] = 1;
        //  adjmatrix[j][i] = 1;
     }


     public void bfs(int src){
        boolean [] visited = new boolean[v+1];
        distance = new int[v+1];

        for(int i =0;i<=v;i++){
            distance[i] = -1;
        }

         Queue<Integer>q = new LinkedList<>();


         q.add(src);
         visited[src] = true;
         distance[src] = 0;




         while(q.size()!=0){
             int element = q.poll();
             for(int i = 0;i<=v;i++){
                 if(adjmatrix[element][i] == 1 && !visited[i]){

                     if(element == src){
                        count++;
                     }
                     q.add(i);
                     visited[i] = true;
                     distance[i] = distance[element]+1;
                 }
             }
         }
     }

     public void print(){


        System.out.println("The distance of each vertex from the source vertex is:");

        for(int i =1;i<v;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println(distance[v]);
     }



     public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

         System.out.println("Enter the number of vertices and edges");

         int V = sc.nextInt();
         int E = sc.nextInt();



        DistanceBFS g = new DistanceBFS(V,E);

        System.out.println("Enter the edges");

        for(int i=0;i<E;i++){

            int u = sc.nextInt();
            int v = sc.nextInt();
            g.add(u,v);

        }

        System.out.println("Enter the source vertex");

        int src = sc.nextInt();

        g.bfs(src);

        g.print();

        sc.close();
     }


 }

```

## Example

Consider the following graph:

```
     A -- B -- C
     |    |    |
     D -- E -- F
```

If `A` is the source node, the distances to other nodes would be:

- Distance to `A`: 0
- Distance to `B`: 1
- Distance to `D`: 1
- Distance to `E`: 2
- Distance to `C`: 2
- Distance to `F`: 3

## Conclusion

Using BFS to calculate the shortest distance from a source node in an unweighted graph is efficient and straightforward. This method ensures that the shortest path is found by exploring nodes level by level.
