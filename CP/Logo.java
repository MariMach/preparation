package jnjd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Logo {

	 public static void main(String[] args) throws Exception {
	        
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int t = 0;  
	        t = Integer.parseInt(br.readLine());
	        
	        for(int i = 0; i < t; i++) {
		        int n = 0, r = 0; 
		        n = Integer.parseInt(br.readLine());
		          int numberofUnits = 0, pos = 0, x = 0, y = 0, angle = 0;
		          String command = "";
		        for(int j = 0; j < n; j++) {
		        	StringTokenizer st = new StringTokenizer(br.readLine());
			          command = st.nextToken();
			          numberofUnits = Integer.parseInt(st.nextToken());
			          if(command.equals("fd")) {			          
			        	  double radians = Math.toRadians(angle); 
			        	  x = (int) (x + numberofUnits*Math.cos(Math.PI-radians));
			        	  y = (int) (y + numberofUnits*Math.sin(Math.PI-radians));

			          } else if(command.equals("lt")) {			        	  
				         angle = (angle + numberofUnits)%360;

			          } else if(command.equals("bk")) {
			        	  double radians = Math.toRadians(angle); 
			        	  x = (int) (x - numberofUnits*Math.cos(Math.PI-radians));
			        	  y = (int) (y + numberofUnits*Math.sin(Math.PI-radians));
			        	  
			          } else if(command.equals("rt")) {		        	  
			        	 angle = (angle + numberofUnits)%360;

			          }
			        		              
		        } 
				   r = (int) Math.floor(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)));  
		         bw.write(r+"\n");
		         bw.flush();
	        }
	        bw.close();
	        br.close();
	        return;
	    }
}
