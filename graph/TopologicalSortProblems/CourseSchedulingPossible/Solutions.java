/**
 * links : https://leetcode.com/problems/course-schedule/submissions/
 */

package TopologicalSortProblems.CourseSchedulingPossible;
import java.util.*;
public class Solutions {
    public boolean topoSort(int numCources,Map<Integer,ArrayList<Integer>> graph,int[] inDegree){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> topoOrder=new ArrayList<>();
        boolean[] visited=new boolean[numCources]; 
        
        for(int i=0;i<numCources;i++){
            if(inDegree[i]==0){
                visited[i]=true;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            Integer v=q.poll();
            topoOrder.add(v);
            if(graph.get(v) !=null ){
                for(int i : graph.get(v)){
                    if(visited[i]==false){
                        inDegree[i]--;
                        if(inDegree[i]==0){
                            q.add(i);
                            visited[i]=true;
                        }
                    }
                }
            }
        }
        return topoOrder.size()==numCources;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>> graph=new HashMap<>();
        int[] inDegree=new int[numCourses];
        for(int[] i : prerequisites){
            graph.putIfAbsent(i[0],new ArrayList<Integer>()); 

            graph.get(i[0]).add(i[1]);
            inDegree[i[1]]++;
        }
        return topoSort(numCourses,graph,inDegree); 
    }
}
