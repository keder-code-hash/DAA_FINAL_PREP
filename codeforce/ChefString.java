/**
 * XYXXYXY
 * 
 * 
 * 
 * */


package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ChefString {
	public static void solve(String inp) {
		int count=0,i=0;
		while(i<inp.length()-1){
			if(inp.charAt(i)=='x' && inp.charAt(i+1)=='y') {
				count++;
				i+=2;
			}
			else if(inp.charAt(i)=='y' && inp.charAt(i+1)=='x') {
				count++;
				i+=2;
			}
			else{
				i++;
			}
		}
		System.out.println(count+"\n");
	}
	public static void main(String[] a) throws IOException,java.lang.Exception{
		BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bfReader.readLine());
		for(int i=0;i<T;i++) {
			String inpString=bfReader.readLine();
			solve(inpString);
		}
		bfReader.close();
	}
}
