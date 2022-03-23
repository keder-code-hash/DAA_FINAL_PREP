package codeforce;

import java.io.*;
 

public class IntegerMoves {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
		int count=Integer.parseInt(bfReader.readLine());
		for(int i=0;i<count;i++) {
			String inpString=bfReader.readLine();
			int a=Integer.parseInt(inpString.split(" ")[0]);
			int b=Integer.parseInt(inpString.split(" ")[1]);
			System.out.println(solve(a,b)); 
		}
		bfReader.close();

	}

	private static int solve(int a, int b) {
		if(a==0 && b==0) {
			return 0;
		}
		int sq=(int) (Math.pow(a, 2)+Math.pow(b, 2));
		if((Math.sqrt(sq)%1)==0) {
			return 1;
		}
		else {
			return 2;
		}
		
	}

}