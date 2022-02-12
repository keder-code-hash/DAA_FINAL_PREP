/**
 * iterate over all the element twice always.
 * total comaparison=n^2
 */




public class Bulbblesort {
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int t:arr){
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
        int[] arr={4,1,54,21,2};
        bubbleSort(arr);
    }
}
