/**
 * best case : O(N)
 * average case/worst case : O(N^2)
 * 
 * advantage : less no of swaps or right dhift operation if array is almost sorted.
 *              worst case is achieved if the array is sorted in reverse order.
 * 
 * for iteration i : from index 0 to i all elements are sorted.
 * 
 * stable sort(if there are any equal elemnt they don't swap their position) but depends upon implementation too.
 * 
 * ALGO : In each iteartion take an element arr[i], and comapre it to the left elements of it(iterate by j).
 *          If any element left to it, is lesser than the arr[i] then shift the elemnet to its right.
 *          Repeat this step until j>0.Lastly put the arr[i] value to arr[j].
 * 
 * 
 */



public class Insertionsort {
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int value=arr[i];
            int j=i;
            while (j>=1 && arr[j-1]>value) {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=value;
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] arr={4,1,54,21,2};
        insertionSort(arr);
    }
}
