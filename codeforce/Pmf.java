//https://codeforces.com/contest/1629/problem/D

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pmf {
    public static boolean isPalindrom(String a){
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i)!=a.charAt(a.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void solve(int size,String[] seq) {
        boolean find=false;
        for(int i=0;i<size;i++){
            if(seq[i].length()==1){
                find=true;
                break;
            }
            for(int j=i+1;j<size;j++){
                // System.out.println(seq[i]+seq[j]+"-->"+isPalindrom(seq[i]+seq[j]));
                if(isPalindrom(seq[i]+seq[j])){
                    find=true; 
                    break;
                }
            }
        }
        if(find==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(bfReader.readLine());
        for(int i=0;i<test;i++){
            int size=Integer.parseInt(bfReader.readLine());
            String[] inp=new String[size];
            for(int j=0;j<size;j++){
                inp[j]=bfReader.readLine();
            }
            solve(size, inp);
        }
        bfReader.close(); 
    }
}
