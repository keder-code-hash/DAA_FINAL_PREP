//      0
//     / \ 
//    1   2
//         \
//          3

//    --------- 
//    ￬       |
//    0-->1-->2
//        ￬
//        3
class UnionFind{
    public static void makeSet(int a,int[] parent) {
        parent[a]=a;
    }
    // O(n)
    public static int findSet(int a,int[] parent){
        if(parent[a]==a){
            return parent[a];
        }
        return findSet(parent[a], parent);
    }
    // O(log n)
    public static int findSetPathComp(int a,int[] parent){
        int temp=a;
        while(temp!=parent[temp]){
            temp=parent[temp];
        }
        // compression 
        while(a!=temp){
            int next = parent[a];
            parent[a] = temp;
            a = next;
        }
        return a;
    }
    public static void makeUnion(int a,int b,int[] parent){
        int x = findSetPathComp(a, parent);
        int y = findSetPathComp(b, parent);
        if(x!=y){
            parent[x]=y;
        }
    }
    public static void main(String[] args) {
        int[] parent = new int[4];
        for(int i=0;i<4;i++){
            makeSet(i, parent);
        }        
        makeUnion(1, 0, parent);
        makeUnion(2, 1, parent);
        makeUnion(3, 1, parent);
        makeUnion(0, 2, parent);

        for(int i=0;i<4;i++){
            System.out.println("parent of "+i+" "+parent[i]);
        }
    }
}