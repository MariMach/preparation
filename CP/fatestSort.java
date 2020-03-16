import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class fatestSort {
	
	public static void countingSort(int[] a) {
	      int max = 0;
	      for (int x : a) {
	        max = Math.max(max, x);
	      }
	      int[] cnt = new int[max + 1];
	      for (int x : a) {
	        ++cnt[x];
	      }
	      for (int i = 1; i < cnt.length; i++) {
	        cnt[i] += cnt[i - 1];
	      }
	      int n = a.length;
	      int[] b = new int[n];
	      for (int i = 0; i < n; i++) {
	        b[--cnt[a[i]]] = a[i];
	      }
	      System.arraycopy(b, 0, a, 0, n);
	    }

	public static void main(String args[]) throws Exception{
		int MOD = 1000000007; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[]  arrlist = new int[n];
		int[]  arrlistpow = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arrlist[i] = Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(arrlist);
		countingSort(arrlist);
		
		long r = 0;
		arrlistpow[0] = 1;
		for (int i = 1; i < n; i++) {
			//arrlistpow[i] = (arrlistpow[i-1]*2) % MOD; 
			arrlistpow[i] =  (arrlistpow[i-1] << 1L) % MOD;
		}
		
		for (int i = 0; i < n; ++i) {
			r += (arrlist[i]*arrlistpow[i]) - (arrlist[i]*arrlistpow[n - 1 - i]);
			r %= MOD;
		}
		bw.write(r + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
