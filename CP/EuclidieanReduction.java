import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EuclidieanReduction {	
	
	 public static long gcd(long m, long n){
		 if(n == 0) {
			 return m;
		 }else {
			 return gcd(n, m%n);
		 }
	  } 
	  public static void main(String args[] ) throws Exception {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  	 int n = Integer.parseInt(br.readLine()); 	 
	  	 for(int i = 0; i < n; i++) {
		  	 StringTokenizer st = new StringTokenizer(br.readLine());
		  		 Long a = Long.parseLong(st.nextToken());
		  		 st.nextToken();
			  		 Long b = Long.parseLong(st.nextToken());			  		
			  		 if(b == 1) {
			  			 System.out.println(a);
			  		 }else if(a%b == 0) {
			  			 System.out.println(a/b);
			  		 }else {
			  			 long c = gcd(a,b);
			  			 System.out.println(a/c + " / " + b/c);
			  		 }		  	 
	  	 }	  	   	 
  }
}
