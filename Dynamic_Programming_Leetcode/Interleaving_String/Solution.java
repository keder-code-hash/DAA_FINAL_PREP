package Interleaving_String;
/**
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * link : https://leetcode.com/problems/interleaving-string/ 
 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()){
            return false;
        }
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=s2.charAt(j-1)==s3.charAt(i+j-1) ? dp[i][j-1] : false;
                }
                else if(j==0){
                    dp[i][j]=s1.charAt(i-1)==s3.charAt(i+j-1) ? dp[i-1][j] : false;
                }
                else{
                    if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                        dp[i][j]=dp[i-1][j];
                    }
                    // dp[i][j] shold be cjhecked cause in previous block it can be turned into true
                    if(!dp[i][j] && s2.charAt(j-1)==s3.charAt(i+j-1)){
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}