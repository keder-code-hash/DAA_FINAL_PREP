// problem : https://leetcode.com/problems/trapping-rain-water/

/** 
 * concept : Two-pointer.Make a track of left and right max.if current height is
 *              less than the left max include it to answer and otherwise update 
 *              the left max to height[left].Same to be applied for right one.
 * 
 * */
package trap_water;
class Solution {
    public int trap(int[] height) { 
        int left=0,l_max=0,right=height.length-1,r_max=0,ans=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=l_max){
                    l_max=height[left];
                }
                else{
                    ans+=l_max-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=r_max){
                    r_max=height[right];
                }
                else{
                    ans+=r_max-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}