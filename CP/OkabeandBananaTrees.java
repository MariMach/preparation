package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OkabeandBananaTrees {
	public static void main(String[] str) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		long y = b;
		long x = (long)m * (long)b;
		long sum = 0, max = 0;
		for(long i = 0; i <y; i++) {
			sum = 0;
			for(long j = 0; j <x; j++) {
				if( ((double)(-j)/(double)m + (double)b) >= (double)i ){
					sum = sum + i+j;
					max = Math.max(max, sum);
				}				
			}
		}
		System.out.println(max);
	}
}
