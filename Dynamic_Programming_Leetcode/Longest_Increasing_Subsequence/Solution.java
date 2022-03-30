// https://leetcode.com/problems/longest-increasing-subsequence/
/**
 * Here we have to a dp array which will contain the insreasing subarray at last.For each of the index we 
 * have two option 
 *          1. nums[i]<dp[len-1]:
 *                  here we always check the last inserted element, if greater than than the current nums array value or not if so we can inert
 *                      the value into array.
 *          2. other wise we have to check 
 *                         a. if current element of nums is found in dp ,if so we can insert new nums element into dp array.
 *                         b. otherwise we have to reset the whole array, means inert the current element to 0 th index of 
 *                              dp array and proceed further.
 * 
 */

package Longest_Increasing_Subsequence;
import java.util.*;
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int len=1;
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[len-1]){
                dp[len++]=nums[i];
            }
            else{
                int foundIndex=Arrays.binarySearch(dp,0,len,nums[i]);
                if(foundIndex<0){
                    foundIndex=-(foundIndex+1);
                }
                dp[foundIndex]=nums[i];
            }
        }
        return len;
    }
}
