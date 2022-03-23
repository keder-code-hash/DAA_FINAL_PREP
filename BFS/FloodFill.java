import java.util.*;
class FloodFill{
	public static void solve(char[][] mat,int x,int y,char replaceChar,char targetChar){
		int rowNo=mat.length;
		int colNo=mat[0].length;
		
		if(x<0 || x>=rowNo || y<0 || y>=colNo || mat[x][y]!=targetChar){
			return ;
		} 

		mat[x][y]=replaceChar;
		solve(mat,x+1,y,replaceChar,targetChar);
		solve(mat,x,y+1,replaceChar,targetChar);
		solve(mat,x,y-1,replaceChar,targetChar);
		solve(mat,x-1,y,replaceChar,targetChar);
		return ;	
	}
	public static void main(String[] args){
		char[][] mat={
		{'Y', 'Y', 'Y', 'G', 'G', 'G', 'G', 'G', 'G', 'G'},
		{'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'G', 'V', 'V', 'V'},
		{'G', 'G', 'G', 'G', 'G', 'G', 'G', 'V', 'V', 'V'},
		{'W', 'W', 'W', 'W', 'W', 'G', 'G', 'G', 'G', 'V'},
		{'W', 'R', 'R', 'R', 'R', 'R', 'G', 'V', 'V', 'V'},
		{'W', 'W', 'W', 'R', 'R', 'G', 'G', 'V', 'V', 'V'},
		{'W', 'B', 'W', 'R', 'R', 'R', 'R', 'R', 'R', 'V'},
		{'W', 'B', 'B', 'B', 'B', 'R', 'R', 'V', 'V', 'V'},
		{'W', 'B', 'B', 'V', 'B', 'B', 'B', 'B', 'V', 'V'},
		{'W', 'B', 'B', 'V', 'V', 'V', 'V', 'V', 'V', 'V'}
		};
		char replaceChar='O';
		char targetChar=mat[3][9];
		solve(mat,3,9,replaceChar,targetChar);
		for(char[] i: mat){
			String op="";
			for(char j: i){
				op+=j+" ";
			}
				System.out.println(op+"\n");
		}
	}

}


