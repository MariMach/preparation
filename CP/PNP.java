import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PNP {
    public static void main(String args[] ) throws Exception {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	   	 StringTokenizer st = new StringTokenizer(br.readLine());
    	 while( st != null) {
    		 int c = 0, v = 0;
	  	   	 while (st.hasMoreTokens()) {
	           String mot = st.nextToken();
	           for(int i = 0; i < mot.length(); i++) {
	        	   if(mot.charAt(i) == 'a' ||  mot.charAt(i) == 'e' || mot.charAt(i) ==  'i' || mot.charAt(i) == 'o' || mot.charAt(i) == 'u' ||  mot.charAt(i) == 'y') {
	        		   v++;
	        	   }
	           }
	           c++;
	  	   	 }	  	   	 
	  	   if(v == 2*c) {
	  	   		System.out.println("NP");
	  	   	}else {
	  	   		 System.out.println("P");
	  	   	}
	  	   	  st = new StringTokenizer(br.readLine());
	  	} 
    }
}
