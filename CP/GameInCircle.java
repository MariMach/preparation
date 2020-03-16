import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameInCircle {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			long n = Long.parseLong(br.readLine());
			long r = 0;	
			long m = (long) Math.floor( Math.log(n)/Math.log(2) );
			r = (long) (2*(n-Math.pow(2,m))+1);
			bw.write(r +"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}