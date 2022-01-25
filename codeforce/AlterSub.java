package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlterSub {
	public static void solve(int size,int[] inp) {
		int[] dp=new int[size];
		dp[inp.length-1]=1;
		for(int i=inp.length-2;i>=0;i--) {
			if(inp[i]<0 && inp[i+1]>0) {
				dp[i]=dp[i+1]+1;
			}
			else if(inp[i]>0 && inp[i+1]<0) {
				dp[i]=dp[i+1]+1;
			}
			else {
				dp[i]=1;
			}
		}
		for(int i:dp) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	public static void main(String[] a) throws IOException,java.lang.Exception{
		BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bfReader.readLine());
		for(int i=0;i<T;i++) {
			int size=Integer.parseInt(bfReader.readLine());
			String[] inpString=bfReader.readLine().split(" ");
			int[] inp=new int[size];
			for(int j=0;j<size;j++) {
				inp[j]=(int) Integer.parseInt(inpString[j]);
			}
			solve(size,inp);
		}
		bfReader.close();
	}
}
