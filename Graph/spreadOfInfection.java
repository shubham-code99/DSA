import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class spreadOfInfection {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      int count=0;

    //   ---------------------Method 1------------------------------------------------

    //   ArrayDeque<Integer> q=new ArrayDeque<>();
    //   q.add(src);
    //   boolean[] vis=new boolean[vtces];
    //   while(q.size()>0 && t>0){
    //     int size=q.size();
        
    //     while(size>0){
    //         int rem=q.remove();
    //         if(vis[rem]==true)  {size-=1;continue;}
    //         vis[rem]=true;
    //         count+=1;
    //         for(Edge e:graph[rem]){
    //             q.add(e.nbr);
    //         }
    //         size-=1;
    //     }
    //     t-=1;
    //   }


    //   ---------------------Method 2--------------------------------------------------

        ArrayDeque<pair> q=new ArrayDeque<>();
        q.add(new pair(src,1));
        boolean[] vis=new boolean[vtces];
        while(q.size()>0){
            pair rem=q.remove();
            if(vis[rem.v]==true)    continue;
            vis[rem.v]=true;
            if(rem.t>t) break;
            else count+=1;
            for(Edge e:graph[rem.v]){
                q.add(new pair(e.nbr,rem.t+1));
            }
        }

      System.out.println("count: "+count);

   }

   public static class pair{
    int v;
    int t;
    pair(int v, int t){
        this.v=v;
        this.t=t;
    }
   }

}