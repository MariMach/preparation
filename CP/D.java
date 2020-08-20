
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = 0;
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = 0, r = 0, k = 0, sumc = 0, sumq = 0, c = 0, q = 0, sum = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer stc = new StringTokenizer(br.readLine());
			StringTokenizer stq = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				c = Integer.parseInt(stc.nextToken());
				q = Integer.parseInt(stq.nextToken());
				sumc = sumc + c;
				sumq = sumq + q;
				if (sumq != 0) {
					sum = (int) sumc / sumq;
				}
				if (sum == k) {
					r = Math.max(r, sumc);
				}
			}
			if (r == 0) {
				r = -1;
			}
			if (k <= 0 || k > 10) {
				r = -1;
			}
			bw.write(Long.toString(r) + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
		return;
	}
}
