package TopologicalSortProblems;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort{
    public static void topoSort(int[][] adjMat,int nodes) {
        boolean[] visited=new boolean[nodes];
        int[] inDegree=new int[nodes];
        Queue<Integer> q=new LinkedList<Integer>();
        ArrayList<Integer> topoOrder=new ArrayList<>();
        /***
         * calculating indegree for each of the vertexes.
         */
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(adjMat[i][j]==1){
                    inDegree[j]+=1;
                }
            }
        }
        /**
         * if indegree of any vertex in 0 then we will enqueue it to a queue.Means if indegree is 0 then it has no dependency,it 
         * can appear first.and maintaing a visited array to prevent from repeatting.
         */
        for(int i=0;i<nodes;i++){
            if(inDegree[i]==0){
                q.add(i);
                visited[i]=true;
            }
        }
        /**
         * while q is not empty,we have to choose the every edge between v(=popped from q)-->u[0..n] and if u is not visited we can
         * remove the edge between them means decrease indegree of u.
         * Now if indegree of u is 0 then push it to queue and we can use this u for next iteartion as it has no dependency now.
         */
        while(!q.isEmpty()){ 
            Integer v=q.poll();
            topoOrder.add(v);
            for(int u=0;u<nodes;u++){
                if(adjMat[v][u]==1 && visited[u]==false){
                    inDegree[u]--; 
                    if(inDegree[u]==0){ 
                        q.add(u);
                        visited[u]=true;
                    }
                }
            }
        }
        for(Integer i: topoOrder){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws IOException{ 
        int[][] adjMat=new int[6][6]; 
        // int[][] sdMat=new int[][]{{0,1},{1,2},{0,3},{1,3},{3,2},{2,4},{2,5},{3,5},{4,5}};
        int[][] sdMat=new int[][]{{0,1},{1,2},{0,3},{1,3},{2,3},{2,4},{2,5},{3,5},{4,5}};
        for(int[] i:sdMat){
            adjMat[i[0]][i[1]]=1;
        }
        topoSort(adjMat, 6);
    }
}