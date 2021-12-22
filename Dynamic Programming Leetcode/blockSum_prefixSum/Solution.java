// problem :https://leetcode.com/problems/matrix-block-sum/
// solution concept : https://www.dcc.fc.up.pt/~pribeiro/aulas/pc2021/material/prefixsums.html
// v.v.i : prefix sum in 2d matrix
// include and exclude technique (explanation : https://leetcode.com/problems/range-sum-query-2d-immutable/solution/)

package blockSum_prefixSum;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res=new int[mat.length][mat[0].length];
        int[][] psa=new int[mat.length+1][mat[0].length+1];

        for(int i=1;i<=mat.length;i++){
            for(int j=1;j<=mat[0].length;j++){
                psa[i][j]=psa[i-1][j]+psa[i][j-1]-psa[i-1][j-1]+mat[i-1][j-1];
            }
        }

        for(int i=1;i<=mat.length;i++){
            for(int j=1;j<=mat[0].length;j++){
                int r1=Math.max(1,i-k);
                int r2=Math.min(mat.length,i+k);
                int c2=Math.min(mat[0].length,j+k);
                int c1=Math.max(1,j-k);

                res[i-1][j-1]=psa[r2][c2]-psa[r1-1][c2]-psa[r2][c1-1]+psa[r1-1][c1-1];
            }
        }

        return res;
    }
}
