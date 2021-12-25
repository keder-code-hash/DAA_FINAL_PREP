// problem : https://leetcode.com/problems/minimum-falling-path-sum/
// concept : (mine)
/**
 * If we have to choose the minimum path according to a certain conditio then it will be as,current path
 * value + min(all possible path value).Because we have to tak the current path.Now to minimize it we can
 * take the minimum of the previous possible ones.
 * 
 * 
 * 
 */


package minimum_sum_falling_path;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                }
                else if(j==0){
                    dp[i][j]=dp[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==matrix[0].length-1){
                    dp[i][j]=dp[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i][j]+Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]);
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            result=Math.min(result,dp[matrix.length-1][i]);
        }
        return result;
    }
}
