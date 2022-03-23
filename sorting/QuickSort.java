/**
 * worst case : O(n^2)
 *              1. sorted in revrse order
 *              2. all ements are equal 
 * best/average case : O(nlogn)
 * 
 * 
 */


public class QuickSort {
    public static int partition(int[] arr,int start,int end) {
        int temp=start;
        int pivot=arr[start];
        for(int i=start+1;i<=end;i++){
            if(arr[i]<=pivot){
                temp++;
                int t=arr[i];
                arr[i]=arr[temp];
                arr[temp]=t;
            }
        }
        int t=arr[temp];
        arr[temp]=arr[start];
        arr[start]=t;
        return temp;
    }
    public static void qiuckSort(int[] arr,int start,int end) {
        if(start<end){
            int mid=partition(arr, start, end);
            qiuckSort(arr, start, mid-1);
            qiuckSort(arr, mid+1,end);
        }
    }
    public static void main(String[] args) {
        int[] arr={2,-11,4,3,21,19,1,24,5,12};
        qiuckSort(arr, 0, 7);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
