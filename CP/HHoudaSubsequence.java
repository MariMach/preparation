import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HHoudaSubsequence {

		public static void main(String args[]) throws Exception {
			int MOD = 1000000007; 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			ArrayList<Integer> arrlist2 = new ArrayList<Integer>();
			int n = Integer.parseInt(br.readLine());
			int r = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arrlist.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(arrlist);
			
			arrlist2.add(1);

			for (int i = 1; i < n; i++) {
				arrlist2.add( (arrlist2.get(i-1) * 2) % MOD ); 
			}
			
			for (int i = 0; i < n; ++i) {
				r += arrlist.get(i)*arrlist2.get(i) - arrlist.get(i)*arrlist2.get(n - 1 - i);
				r %= MOD;
			}
			
			bw.write(r + "\n");
			bw.flush();
			bw.close();
			br.close();
		}
	
}

