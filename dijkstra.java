import java.io.*;
import java.util.*;

public class Solution {

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
    void dijkstra(int [][]adjMat,int s,int n){
        int []cost=new int[n+1];
        boolean []visited=new boolean[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[s]=0;
        for(int i=1;i<=n;i++){
            int k=minDistance(cost,visited,n);
            visited[k]=true;
            for (int j=1;j<=n;j++){                 
                if (!visited[j] && adjMat[k][j]!=0 && cost[k]+adjMat[k][j] < cost[j])
                    cost[j] = cost[k] + adjMat[k][j];                
            }            
        }
        String str="";
        for(int i=1;i<n+1;i++){
            if(i==s)
                continue;
            else{
                cost[i]=(cost[i]==Integer.MAX_VALUE?-1:cost[i]);
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
            int [][]adjMat=new int[n+1][m+1];
            for(int j=0;j<m;j++){
                int a=in.nextInt();
                int b=in.nextInt();               
                adjMat[a][b]=in.nextInt();
            }
            int s=in.nextInt();                   
            Solution sl=new Solution();
            sl.dijkstra(adjMat,s,n);
        }
    }
}
