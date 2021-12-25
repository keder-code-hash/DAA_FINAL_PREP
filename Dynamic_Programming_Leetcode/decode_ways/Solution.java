// problems : https://leetcode.com/problems/decode-ways/submissions/
// concept : same as word break problem.
/**
 * Take an arraylist to store the numbers(can be omitted and done using normal ascii range also).Then iterate over the whole input string.
 * Now, pick the substring upto i and check is the substring can be made by stored numbers or not.If it can be made just add 1 to this position.
 * Now, if check for the substring of current substring.Because they can be made some ways and it has to be added.But good thing is they are 
 * calculated previously,So we won't calculate again.
 * Just for substring upto i,check for all s[0 to j (j<=i)] if they can be be made, add this value to dp[i].
 * 
 */
package decode_ways;
import java.util.*;

public class Solution {
    public static int numDecodings(String s) {
        List<String> newHash=new ArrayList<String>();
        for(int i=1;i<=26;i++){
            newHash.add(Integer.toString(i));
        }
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String sub=s.substring(j,i+1);
                if(newHash.contains(sub)){
                    if(j>0){
                        dp[i]+=dp[j-1];
                    }
                    else{
                        dp[i]+=1;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings(args[0]));
    }
}
