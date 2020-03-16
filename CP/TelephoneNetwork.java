package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TelephoneNetwork {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			long n = Long.parseLong(br.readLine());
			long r = 0;
			/*
			 * Output contains T lines; each line contains the answer 
			 * for that test case. Print 0 if there are no end-to-end
			 *  network possible.
			 */
			 if((n-3)*n/2>0) r=(n-3)*n/2;			 
			 bw.write(r+"\n");
			 bw.flush();
			
		}
		bw.close();
		br.close();
	}

}
