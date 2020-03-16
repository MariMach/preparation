import java.io.*;
import java.util.StringTokenizer;

public class Occur {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int m = 1001;
		int[] arrOcc = new int[m];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int k : arr) {
			arrOcc[k]++;
		}
		
		for(int i = 0; i < m; i++) {
			if(arrOcc[i] != 0) {				
				bw.write(i + " "+ arrOcc[i]+" "+"\n");
				bw.flush();
			}
		}
	}
}
