/**
 * worst/best/average case : O(knlogn)
 *                          k=const. 
 */

public class MergeSort {
    public static void merge(int[] arr,int start,int mid,int end) {
        int len1=(mid-start+1);
        int len2=(end-mid);
        int[] leftArray=new int[len1];
        int[] righttArray=new int[len2];
        for(int i=0;i<len1;i++){
            leftArray[i]=arr[start+i];
        }
        for(int i=0;i<len2;i++){
            righttArray[i]=arr[mid+1+i];
        }
        int i=0,j=0,k=start;
        while(i<len1 && j<len2){
            if(leftArray[i]<=righttArray[j]){
                arr[k]=leftArray[i];
                i++;
            }
            else{
                arr[k]=righttArray[j];
                j++;
            }
            k++;
        }
        while(i<len1){
            arr[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<len2){
            arr[k]=righttArray[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr,int start,int end) {
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void main(String[] args) {
        int[] arr={2,-11,4,3,21,19,1,24,5,12};
        mergeSort(arr, 0, 9);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
