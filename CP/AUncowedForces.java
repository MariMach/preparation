import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class AUncowedForces {
	   public static void main(String args[]) throws IOException {		   	
			     ArrayList<Integer> ms = new ArrayList<Integer>();
			     ArrayList<Integer> ws = new ArrayList<Integer>();
			   	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  	   	 StringTokenizer st = new StringTokenizer(br.readLine());
		  	   	 StringTokenizer stt = new StringTokenizer(br.readLine());
		  	   	 StringTokenizer sttt = new StringTokenizer(br.readLine());
		  	   	 int shacks = 0, unshacks = 0;
		  	   	 float outp = 0;
		  	   	 shacks = Integer.parseInt(sttt.nextToken());
		  	   	 unshacks = Integer.parseInt(sttt.nextToken());
		  	   	 int output = 0;
		    	 while (st.hasMoreTokens()) {
		  	           int aint = Integer.parseInt(st.nextToken()); 
		  	           ms.add(aint);
		    	 }
		    	 while (st.hasMoreTokens()) {
		  	           int bint = Integer.parseInt(stt.nextToken()); 
		  	           ws.add(bint);
		    	 }
			     for(int i = 0; i < ms.size(); i++) {
			    	 int x = 500;
			    	 if(x > 2500) {
			    		 x = 500;
			    	 }
			    	 if(i >= ws.size()) {
			    		 ws.add(0);
			    	 }
			    	 outp = outp + (float) Math.max(0.3*x, (1-(ms.get(i)/250))*x - 50*ws.get(i));
			    	 x = x + 500;
			     }
			     output = (int) Math.ceil(outp);
			     output = output + (shacks*100) - (unshacks*50);
			     System.out.println(output);
	}
}
