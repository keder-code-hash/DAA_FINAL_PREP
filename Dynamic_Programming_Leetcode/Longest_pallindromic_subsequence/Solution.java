/**
 * problems : https://leetcode.com/problems/longest-palindromic-subsequence/
 * solution : https://www.youtube.com/watch?v=RiNzHfoA2Lo
 * 
 * */
// package Dynamic_Programming_Leetcode.Longest_pallindromic_subsequence;

public class Solution {
	public int longestPalindromeSubseq(String s) {
		int[][] dp=new int[s.length()][s.length()]; 
        for(int l=0;l<s.length();l++){
            for(int j=l,i=0;j<s.length();j++,i++){
                if(l==0){
                    // length gap =0
                    dp[i][j]=1;
                }
                else if(l==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }
                    else{
                        dp[i][j]=1;
                    }
                }
                else{
                    if((s.charAt(i)==s.charAt(j))){
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
		return dp[0][s.length()-1];
    }
	public static void main(String[] args) {
		Solution slSolution=new Solution();
		System.out.println(slSolution.longestPalindromeSubseq("bbbab"));

	}

}
