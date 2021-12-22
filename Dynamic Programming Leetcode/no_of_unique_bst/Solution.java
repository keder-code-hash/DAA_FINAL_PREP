package no_of_unique_bst;
// problems : https://leetcode.com/problems/unique-binary-search-trees/
// solution : pepcoding
// concept : to construct a bst of node number 3, we can split up the node in this way [0,1,2],[1,1,1],
//          [2,1,0] now with node of 0 bst can be made in 1 way and similarly for 1 it eill be 1 and for
//          for 2 it will be 2.So if we now calculate it for 3
//          [0,1,2]=0->1;2->2=>1*2=2
//          [1,1,1]=1->1;1->1=>1*1=1
//          [2,1,0]=2->2;0->1=>2*1=2
//          total will be 5.


class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            System.out.println(dp[i]);
            int right=i-1;
            int left=0;
            while(left<=i-1){
                dp[i]+=dp[left]*dp[right];
                left++;
                right--;
            }
        } 
        return dp[n];
    }
}