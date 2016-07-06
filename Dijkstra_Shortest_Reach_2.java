import java.io.*;
import java.util.*;

public class Solution {

    private static class Vertex{
        int vertex,weight;
        Vertex(int vertex, int weight){
            this.vertex=vertex;
            this.weight=weight;
        }
    }
    int minDistance(int []cost, boolean []visited,int n)
    {        
        int min = Integer.MAX_VALUE, min_index=-1;
        for (int i=1;i<=n;i++)
            if (visited[i]==false && cost[i]<=min)
            {
                min=cost[i];
                min_index=i;
            }
        return min_index;
    }
    void dijkstra(LinkedList<Vertex> []adjList,int s,int n){
        int []cost=new int[n+1];
        boolean []visited=new boolean[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[s]=0;
        for(int i=1;i<=n;i++){
            int k=minDistance(cost,visited,n);
            visited[k]=true;
            if(adjList[k]!=null){
                
                Iterator<Vertex> itr=adjList[k].iterator();
                while(itr.hasNext()){
                    Vertex ver=itr.next();
                    int v=ver.vertex;
                    int w=ver.weight;
                    
                    if (!visited[v]  && cost[k]+w < cost[v])
                    cost[v] = cost[k] + w;    
                }
                
            }
            
                                
                        
        }
        String str="";
        for(int i=1;i<n+1;i++){
            if(i==s)
                continue;
            else{
                cost[i]=((cost[i]<0||cost[i]==Integer.MAX_VALUE)?-1:cost[i]);
                str+=cost[i]+" ";
            }
        }
        System.out.println(str);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int m=in.nextInt();
            LinkedList<Vertex> []adjList=new LinkedList[n+1]; 
            for(int j=0;j<m;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                int r=in.nextInt();                
                if(adjList[a]==null)		        
		            adjList[a]=new LinkedList<Vertex>();
		        adjList[a].add(new Vertex(b, r));
		        if(adjList[b]==null)		        
		            adjList[b]=new LinkedList<Vertex>();		           		
		        adjList[b].add(new Vertex(a, r));
            }
            int s=in.nextInt();                   
            Solution sl=new Solution();
            sl.dijkstra(adjList,s,n);
        }
    }
}
