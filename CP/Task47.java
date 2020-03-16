package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Task47 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			long r = 0;			
			StringTokenizer stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < p; i++) {
				// All array elements are prime numbers
				int a = Integer.parseInt(stt.nextToken());	
				if(!hashmap.containsKey(a)) {
					hashmap.put(a, i);
					arrl.add(a);
				}
			}
			for(int i = 0; i < arrl.size(); i++) {
				r += n/arrl.get(i);
			}
					
			bw.write(r+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
