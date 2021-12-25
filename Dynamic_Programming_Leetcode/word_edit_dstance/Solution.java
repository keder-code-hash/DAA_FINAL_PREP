/**
 * problems : https://leetcode.com/problems/edit-distance/
 * 
 * Concept : suppose you have two words w1 and w2.And we can do three ops insertion deletion and replce
 *          and for each of the ops we have to pay an cost of 1 to change w1 to w2.Subprlems for this
 *          problems can be defined as smaller length of words.According to row w1 is taken and according to 
 *          col w2 is taken.For delete a character from w1 we can take the cost upto dp[i-1][j]+1(extra for
 *          deletion op).And for insertion we can take dp[i][j-1]+1(for insertion operation we can take previous
 *          cloumn value) and add one.
 *          Now in case of replace operation we can check upto dp[i-1][j-1] means current calculated ditance
 *          if for both word i-1 and j-1 is same no need to replace but they differ we cna take prev value+1
 * 
 *          And lastly choose the correct operation as minimum value
 *          
 *          dp[i][j]=Math.min(Math.min(dp[i-1][j]+1, // do not take the word1 char so deletion
 *                                         dp[i][j-1]+1  // take char of word2 so addition
 *                                        ),dp[i-1][j-1]+substCost);
 * 
 */

package word_edit_dstance;

class Solution{
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=word2.length();i++){
            dp[0][i]=i;
        }
        int substCost=0;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){// substituition
                    // no requirement of substituition
                    substCost=0;
                }
                else{
                    substCost=1;
                }
                dp[i][j]=Math.min(Math.min(dp[i-1][j]+1, // do not take the word1 char so deletion
                                          dp[i][j-1]+1  // take char of word2 so addition
                                          ),dp[i-1][j-1]+substCost);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}