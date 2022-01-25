import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.HashMap;
import java.util.Map; 

class Elementery{
    public static int solution(int[] arr,int size){
        int ans=-1;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<size;i++){
            if(hash.containsKey(arr[i])==false){ 
                hash.put(arr[i], i); 
            } 
            else{
                // System.out.println("value: "+hash.get(arr[i])+" "+hash.containsKey(arr[i]));
                int firstFound=hash.get(arr[i]);
                int lastFound=i;
                int left=firstFound;
                int right=size-1-lastFound;
                ans=Math.max(ans,left+right+1);
                hash.put(arr[i],i); 
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
        int itr=0;
        itr=Integer.parseInt(bfReader.readLine());;
        for(int i=0;i<itr;i++){
            int size=Integer.parseInt(bfReader.readLine());
            String[] input=bfReader.readLine().split(" ");
            int[] arr=new int[size];
            for(int j=0;j<size;j++){
                arr[i]=Integer.parseInt(input[j]);
            }
            System.out.println(solution(arr, size)+"\n");
        }
        bfReader.close();
    }
}