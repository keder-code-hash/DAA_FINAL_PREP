// package LongestPallindromicSubstring;
// solution : https://www.youtube.com/watch?v=WpYHNHofwjc
class Solution{
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        String pallindrom=""; 
        for(int l=0;l<s.length();l++){
            for(int j=l,i=0;j<s.length();j++,i++){
                if(l==0){
                    // length gap =0
                    dp[i][j]=true;
                }
                else if(l==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
                else{
                    if((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]){ 
                    pallindrom=s.substring(i,j+1);
                }
            }
        }
        // for(boolean[] b: dp){
        //     String res=" ";
        //     for(boolean c:b){
        //         res+=Boolean.toString(c)+" ";
        //     }
        //     System.out.println(res);
        // }
        return pallindrom;
    }
    public static void main(String[] args) {
        Solution sl=new Solution();
        System.out.println(sl.longestPalindrome("babad"));
        System.out.println(sl.longestPalindrome("cbbd"));
    }
}