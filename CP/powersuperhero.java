import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class powersuperhero {
	 public static void main(String args[] ) throws Exception {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  	StringTokenizer st = new StringTokenizer(br.readLine());
  		StringTokenizer stt = new StringTokenizer(br.readLine());
  		int n = Integer.parseInt(st.nextToken());
  		int k = Integer.parseInt(st.nextToken());
  		int m = Integer.parseInt(st.nextToken());
  		double r = 0, sum = 0, sumM = 0;
  		int inc = 0;
  		if(k > m) {
  			k = m;
  		}
  			ArrayList<Long> list = new ArrayList<Long>();
  	  		for(int i = 0; i < n; i++) {
  	  			long a = Long.parseLong(stt.nextToken());
  	  			list.add(a);
  	  			sum = (double) sum + (double) a;
  	  		}
  	  		Collections.sort(list);
  	  		int f = Collections.frequency(list, list.get(list.size()-1));
  	  		if(m >= n-f) {
  	  			if(m-n+f >= k*f) {
  	  	  			r = (double) f*list.get(n-1) + (double) f*k;
  	  			} else {
  	  				r = (double) f*list.get(n-1) + (double) m-n+f;
  	  			}
  	  			r = (double) r / (double) f;
  	  		}else {
  	  			for(int j = 0; j < m; j++) {
  	  				if(list.get(0) != list.get(list.size() - 1)) {
  	  					list.remove(0);
  	  					inc++;
  	  				}  	  				
  	  			}
  	  			for(int g = 0; g < list.size(); g++) {
  	  				r = r + (double) list.get(g);
  	  			}
  	  			r = r +  (double)(m - inc);
  	  			r = (double) r/ (double) list.size();
  	  		}
  	  		
  	  		if(m >= k*n ) {
  	  	  		sumM = (double) sum + (double)(k*n);
  	  	  		sumM = (double) sumM / (double) n;
  	  		}else {
	  	  		sumM = (double) sum + (double)m;
	  	  		sumM = (double) sumM / (double) n;
  	  		}
  	  		
  		if(r < sumM) {
  			r = sumM; 
  		}
  		
  		System.out.printf("%.20f",r);
	 }
}
