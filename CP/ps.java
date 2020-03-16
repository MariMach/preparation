import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ps {
	 public static void main(String args[] ) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  	StringTokenizer st = new StringTokenizer(br.readLine());
  		StringTokenizer stt = new StringTokenizer(br.readLine());
  		int n = Integer.parseInt(st.nextToken());
  		int k = Integer.parseInt(st.nextToken());
  		int m = Integer.parseInt(st.nextToken());
  		double sum = 0, summax = 0, sum2 = 0, tmp = 0; 	
  		ArrayList<Long> list = new ArrayList<Long>();
  	  	for(int i = 0; i < n; i++) {
  	  		long a = Long.parseLong(stt.nextToken());
  	  		list.add(a);
  	  		sum = (double) sum + (double) a;
  	  	}
  	  	if(k > m) {
  	  		k = m;
  	  	}
  	  	Collections.sort(list);
  	  	summax = (double)sum + (double)Math.min(m, n*k);
  	  	summax = (double) summax / (double) n;
  	  	sum2 = sum;
  	  	for(int i = 0; i < Math.min(n-1, m); i++) {
  	  		sum2 = sum2 - list.get(i);
  	  		tmp = sum2 + Math.min(m-1-i, k*(n-1-i));
  	  		summax = Math.max(summax, (double)tmp/(double)(n-i-1));
  	  	} 	  		
  		System.out.printf("%.20f",summax);
	 }
}
