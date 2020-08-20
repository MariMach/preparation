
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlayingwithPaper {
	public static long solve(long a, long b) {
		long c = a % b;
		long d = (long) a / (long) b;
		if (b == 1) {
			return a;
		}
		if (a == b) {
			return 1;
		}
		if (c > b) {
			return d + solve(c, b);
		} else {
			if (c != 0) {
				return d + solve(b, c);
			} else {
				return d;
			}
		}
	}

	public static void main(String[] str) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long r = 0;
		if (a >= b) {
			r = solve(a, b);
		}
		System.out.println(r);
	}
}
