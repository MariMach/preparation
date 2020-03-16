import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class afllipinggame {
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	   int n = Integer.parseInt(br.readLine());
   	   StringTokenizer st = new StringTokenizer(br.readLine());
   	   int nb1 = 0, nb0 = 0,max0 = -1; 
    	for(int i = 0; i < n; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		if(a == 1) {
    			nb1++;
    			if(nb0 > 0) {
    				nb0--;
    			}
    		}else {
    			nb0++;
    			if(nb0 > max0) {
    				max0 = nb0;
    			}
    		}
    	}  
    	System.out.println(nb1+max0);
    }
}
