import java.io.*;
import java.util.*;

public class Solution {

    
    private static Scanner in = new Scanner(System.in);
    private static LinkedList<Integer> []adj;
    private static void initialize(int n,int m){        
        adj=new LinkedList[n+1];
        for(int j=0;j<n;j++)
            adj[j]=new LinkedList();
    }
    private static void bfs(int s,int n){
        int x=0;        
        boolean []visited=new boolean[n+1];
        int []cost=new int[n+1];
        Arrays.fill(cost,-1);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        while(queue.size()!=0){
            s=queue.poll();
            x=x+6;
            cost[s]=x;
            Iterator<Integer> itr=null; 
            try{
                itr = adj[s].listIterator();            
            }           
            while (itr.hasNext())
            {
                int k = itr.next();
                if (!visited[k])
                {
                    visited[k] = true;
                    queue.add(k);
                    cost[k]=x;
                }
            }
        }       
        System.out.println();
    }    
    public static void main(String[] args) {        
        int t = in.nextInt();
        int n = 0, m = 0, s=0;
        int x = 0, y = 0;        
        for(int i = 0 ; i < t ; i++){
            n = in.nextInt();
            m = in.nextInt();
            initialize(n,m);
            for(int j=0;j<m;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                adj[a].add(b);
            }
            s=in.nextInt();
            bfs(s,n);
        }
    }
}
