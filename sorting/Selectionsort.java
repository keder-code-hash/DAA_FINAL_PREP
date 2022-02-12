/**
 * stable sort : preserve the original input sequence of th original array.
 * 
 * time complexity : O(N)[best case]
 *                   O(N^2)[average/worst case]
 */


public class Selectionsort {
    public static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++){

            int minIndex=i,minValue=Integer.MAX_VALUE;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<minValue){
                    minIndex=j;
                    minValue=arr[j];
                }
            } 
            if(minIndex!=i){
                int t=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=t;
            }
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] arr={4,1,54,21,2};
        selectionSort(arr);
    }
}
