import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pt {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	double a = 0, b = 0;
    	if( n%2 == 0) {
    		a = (double) ((double)Math.pow(n,2)/(double)4) - 1;
    		b = (double) ((double)Math.pow(n,2)/(double)4) + 1;
    	}else {
    		a = ((double) Math.pow(n,2)-1)/ (double)2;
    		b = ((double) Math.pow(n,2)+1)/ (double)2;
    	}
    	if((Math.floor(a)==a) && (Math.floor(b)==b) && (a>0) && (b>0)) {
    		System.out.println((long)a + " " + (long)b);
    	}else {
    		System.out.println(-1);
    	}
    }
}