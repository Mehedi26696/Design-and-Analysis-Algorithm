
import java.io.*;
import java.util.*;
 
public class Input_FromFile_BFS {

    int v;
    int [][] adjmatrix;

    Input_FromFile_BFS(int v){
        this.v = v;
        adjmatrix = new int[v][v];
    }

    public void addedge(int i,int j){
        adjmatrix[i][j] = 1;
        adjmatrix[j][i] = 1;
    }


    public void bfs(int src){
        boolean [] visited = new boolean[v];
         
        Queue<Integer>q = new LinkedList<>();


        q.add(src);
        visited[src] = true;


        while(q.size()!=0){
            int element = q.poll();

            System.out.print(element+ " ");

            for(int i = 0;i<v;i++){
                if(adjmatrix[element][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }


    }
    public static void main(String[] args) {

         
         try{
            File  file = new File("input.txt");


              Scanner sc = new Scanner(file);

              int V = sc.nextInt();
              int E =  sc.nextInt();

            //   System.out.println(V+" "+E);

            Input_FromFile_BFS g = new Input_FromFile_BFS(V);

              for(int i=0;i<E;i++){

                     int u = sc.nextInt();
                     int v = sc.nextInt();

                    //  System.out.println(u+" "+v);

                    g.addedge(u, v);
              }

              System.out.print("BFS: ");

              g.bfs(3);
              sc.close();
         }catch (Exception e) {
             e.printStackTrace();
         }



         
    }
}
