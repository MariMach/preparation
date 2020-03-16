import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GFG {

		public static void main(String args[]) throws Exception {
			int MOD = 1000000007; 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int n = Integer.parseInt(br.readLine());
			int[]  arrlist = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arrlist[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrlist);
			
			long min_sum = 0, max_sum = 0; 
			for (int i = 0; i < n; i++) { 
				max_sum = 2 * max_sum + arrlist[n - 1 - i]; 
				max_sum %= MOD; 
				min_sum = 2 * min_sum + arrlist[i]; 
				min_sum %= MOD; 
			} 
			
			bw.write((max_sum - min_sum) + "\n");
			bw.flush();
			bw.close();
			br.close();
		}
	
}


