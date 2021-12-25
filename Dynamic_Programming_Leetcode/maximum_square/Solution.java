/**
 * problems : https://leetcode.com/problems/maximal-square/solution/
 * concept : we can calculate the block sqaure by calculating small square area.And it can be calculated 
 *          by left,up,corner min value(if this dp[i][j]==1)
 *          .Cause if we can take the min value, then value can be reseted by 
 *          getting a value 0.
 */
package maximum_square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row+1][col+1];
        int maxDim=Integer.MIN_VALUE;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    maxDim=Math.max(maxDim,dp[i][j]);
                }
            }
        }
        return maxDim*maxDim;
    }
}
