import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrintAllSubsequencesOfArray {
		public static void main(String args[]) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arrlist.add(Integer.parseInt(st.nextToken()));
			}
			/* Number of subsequences is (2**n -1)*/
			int opsize = (int)Math.pow(2, n); 
			for (int counter = 1; counter < opsize; counter++) { 
			
				for (int j = 0; j < n; j++) { 		
					if (BigInteger.valueOf(counter).testBit(j)) {
				
						bw.write(arrlist.get(j) +" ");		
						bw.flush();
					}
				} 
				bw.write("\n");
				bw.flush();
			} 	
		
			bw.close();
			br.close();
		}
	
}
