import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;


public class HashSetSubsequence {
	
	public static void main(String args[]) throws Exception{
        HashSet<Integer> h = new HashSet<Integer>(); 
        //int MOD = 1000000007; 
        //final long MODULO = (int) (1e9 + 7);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			h.add(Integer.parseInt(st.nextToken()));
		}

        Iterator<Integer> it = h.iterator(); 
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
			bw.flush();
		}
		// could not implement hashset to solve subsequence problem
		bw.write(h.size() + "   size   \n");
		bw.flush();
		bw.close();
		br.close();

	}

}
