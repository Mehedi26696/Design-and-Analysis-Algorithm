 
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
            
        System.out.println("The number of vertices at distance 1 from the source vertex is: "+count);
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
