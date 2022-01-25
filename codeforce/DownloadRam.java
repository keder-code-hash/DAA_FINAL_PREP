import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DownloadRam {
	public static void solve(int size,int initRam,String[] a,String[] b) {
		int[][] info=new int[size][2];
		int finalAmount=initRam;
		for(int i=0;i<size;i++){
			info[i][0]=Integer.parseInt(a[i]);
			info[i][1]=Integer.parseInt(b[i]);
		}
		Arrays.sort(info,new Comparator<int[]>() {
			public int compare(int[] a,int[] b){
				if(a[0]>b[0]){
					return 1;
				}
				if(a[0]==b[0]){
					return 0;
				} 
				return -1; 
			}
		});
		for(int[] t: info){ 
			if(t[0]<=finalAmount){
				finalAmount+=t[1];
			}
			else{
				break;
			}
		}
		System.out.println(finalAmount+"\n");

	}
	public static void main(String[] args) throws IOException{ 
		BufferedReader bfReader=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(bfReader.readLine());
		for(int i=0;i<testCase;i++){
			String[] inp=bfReader.readLine().split(" ");
			int size=Integer.parseInt(inp[0]);
			int initRam=Integer.parseInt(inp[1]);
			String[] a=bfReader.readLine().split(" ");
			String[] b=bfReader.readLine().split(" "); 
			solve(size, initRam, a, b);
		}
		bfReader.close();
	}

}
