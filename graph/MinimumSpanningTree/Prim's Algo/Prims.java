import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Time Complexity : 
 *              1. using mean-heap based priority queue + adjaceny list repr, --> O(vlgv+Elgv)~O(Elgv)
 *                      Elgv : due to [pq.add(new Node(adjMat[selectedNode][i],i));] this operation .for single
 *                              operation it will require lgv,As there can be a max of E iteration so it is Elgv.
 *                      vlgv : inserting the node initially and donig minHeapify.
 * 
 * 
 */

public class Prims {
    class Node{
        public int weight;
        public int vertexNo;
        public int prevVertex;
        public Node(int weight,int vertexNo,int prevVertex){
            this.weight=weight;
            this.vertexNo=vertexNo;
            this.prevVertex=prevVertex;
        }
    }
    public void prims(int[][] adjMat,int vertexNo,int startingVertex) {
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() { 
			@Override
			public int compare(Node o1, Node o2) { 
				if(o1.weight<o2.weight) {
					return -1;
				}
				else if(o2.weight==o1.weight) {
					return 0;
				}
				else {
					return 1;
				}
			}
		});
        
        for(int i=0;i<vertexNo;i++){
            int weight=Integer.MAX_VALUE;
            if(i==startingVertex){
                weight=0;
            }
            pq.add(new Node(weight, i,-1));
        }
//        for(Node n:pq) {
//        	System.out.println(n.weight+" "+n.vertexNo);
//        }
        int weight=0;
        boolean visited[]=new boolean[vertexNo];
        while(pq.size()!=0){
            Node u=pq.poll();
            int selectedNode=u.vertexNo;
            
            if(visited[selectedNode]){
                continue;
            }
            
            weight+=u.weight;
            System.out.println(u.prevVertex+" --> "+u.vertexNo+" "+u.weight);
            visited[selectedNode]=true; 
            
            
            for(int i=0;i<vertexNo;i++){
                if(adjMat[selectedNode][i]!=0){
                    if(visited[i]==false){
//                    	System.out.println(i+" ---> "+u.vertexNo);
                        pq.add(new Node(adjMat[selectedNode][i],i,selectedNode));
                    }
                }
            }
        }
        System.out.println(weight);
    }
    public static void main(String[] args) {
        int[][] adjMat = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };
        int vertexNo=5;
        Prims pr=new Prims();
        pr.prims(adjMat, vertexNo, 0);
    }
}
