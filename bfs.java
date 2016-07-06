import java.io.*;
import java.util.*;

public class Solution {

    private int N;    
    private static LinkedList<Integer> []adj;
    Solution(int n){
        N=n;        
        adj=new LinkedList[n+1];
        for(int j=0;j<n+1;j++)
            adj[j]=new LinkedList();
    }
     
    void addEdge(int a,int b){
        adj[a].add(b);
        adj[b].add(a);
        
    }
   
    void bfs(int s){
        int x=6;    
        int b=s;
        boolean []visited=new boolean[N+1];
        int []cost=new int[N+1];        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;        
        queue.add(s);        
        while(queue.size()!=0){
            s=queue.poll();
            int a=cost[s]+6;
            Iterator<Integer> itr=null; 
            try{
                itr = adj[s].listIterator();            
            }catch(Exception e){
                System.out.println("Exception:"+e);
            }        
            while (itr.hasNext())
            {
                int k = itr.next();
                if (!visited[k])
                {
                    visited[k] = true;
                    queue.add(k);
                    cost[k]=a;
                }
            }
        }   
        String str="";
        for(int i=1;i<cost.length;i++){
            if(i==b)
                continue;
            else{
                cost[i]=(cost[i]==0?-1:cost[i]);
                str+=cost[i]+" ";                
            }
                
        }
        System.out.println(str);
    }    
    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = 0, m = 0, s=0;               
        for(int i = 0 ; i < t ; i++){
            n = in.nextInt();
            Solution sl=new Solution(n);
            m = in.nextInt();            
            for(int j=0;j<m;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                sl.addEdge(a,b);
            }
            s=in.nextInt();
            sl.bfs(s);
        }
    }
}
