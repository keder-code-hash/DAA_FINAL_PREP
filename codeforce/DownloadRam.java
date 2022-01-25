import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DownloadRam {
	public static void solve(int size,int initRam,String[] a,String[] b) {
		int[][] info=new int[size][2];
		for(int i=0;i<size;i++){
			info[i][0]=Integer.parseInt(a[i]);
			info[i][1]=Integer.parseInt(b[i]);
		}
		Arrays.sort(info,new Comparator<int[]>() {
			public int compare(int[] a,int[] b){
				if(a[0]<b[0]){
					return 1;
				}
				else if(a[0]==b[0]){
					if(a[1]>b[1]){
						return 1;
					}
					else{
						return -1;
					}
				}
				else{
					return -1;
				} 
			}
		});
		for(int[] t: info){
			System.out.println(t[0]+" "+t[1]);
		}
	}
	public static void main(String[] args) throws IOException{ 
		BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
		int testCase=0;
		testCase=Integer.parseInt(bfReader.readLine());
		for(int i=0;i<testCase;i++){
			int size=bfReader.read();
			int initRam=bfReader.read();
			String[] a=new String[size];
			String[] b=new String[size];
			a=bfReader.readLine().split(" ");
			b=bfReader.readLine().split(" ");
			solve(size, initRam, a, b);
		}
	}

}
