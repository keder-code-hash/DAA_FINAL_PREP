/**
 * link : https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Concept : 
 *          same as Longest Increasing Subsequence
 * 
 * 
 */
package Russian_Doll;
import java.util.*; 
public class Solution {
    public int maxEnvelopes(int[][] envelops) { 
        Comparator comp=Comparator.comparing((int[] arr)->arr[0]).thenComparing((int[] arr)->arr[1],Comparator.reverseOrder());
        Arrays.sort(envelops,comp);
        
        int[] dp=new int[envelops.length];
        dp[0]=envelops[0][1];
        int len=1;
        for(int i=1;i<envelops.length;i++){
            if(envelops[i][1]>dp[len-1]){
                dp[len++]=envelops[i][1];
            }
            else{
                // if envelops height is less or equal to any dp hieght value,then min height envelops is available we have to put it first.
                int foundIndex=Arrays.binarySearch(dp,0,len,envelops[i][1]);
                if(foundIndex<0){
                    foundIndex=-(foundIndex+1);
                }
                dp[foundIndex]=envelops[i][1];
            }
            
        }
        return len;
    }
}
