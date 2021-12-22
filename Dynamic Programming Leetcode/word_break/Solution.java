// problems : https://leetcode.com/problems/word-break/
// solution : https://www.youtube.com/watch?v=2NaaM_z_Jig
// pepcoding
package word_break;
import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==1){
            return wordDict.contains(s);
        }
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String sub=s.substring(j,i+1);
                if(wordDict.contains(sub)){
                    if(j>0){
                        dp[i]+=dp[j-1];
                    }
                    else{
                        dp[i]+=1;
                    }
                }
            }
        }
        return dp[s.length()-1]>0;
    }
}