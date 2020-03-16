import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class H {
	public static long factt(int n) {
		if(n == 1) {
			return 1;
		}
		return n*factt(n-1);
	}
	  public static void main(String args[] ) throws Exception {
		     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  	 int t = Integer.parseInt(br.readLine()); 	
		  	 for(int i = 0; i < t; i++) {
			  		int n = Integer.parseInt(br.readLine());
			  		long fact = 0, b = 1;
			  		StringTokenizer st = new StringTokenizer(br.readLine());
			  		HashMap<Long, Integer> hm = new HashMap<Long, Integer>(); 	
			  		for(int j = 0; j < n; j++) {
			  			long m = Long.parseLong(st.nextToken());
			  			if(hm.containsKey(m)) {
			  				hm.put(m, hm.get(m) + 1);
			  				b = b * hm.get(m);
			  			}else {
			  				hm.put(m, 1);
			  			}
			  		}
			  		fact = factt(n);
			  	System.out.println(fact/b);			  		 
		  	 }		  	 
	 }
}
