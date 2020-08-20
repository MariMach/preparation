
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittlePonyandExpectedMaximum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		double sum = 0, oldarr = 0;

		for (int i = 1; i <= m; i++) {
			oldarr = Math.pow((double) (i - 1) / (double) m, n);
			sum = sum + i * (Math.pow((double) i / (double) m, n) - oldarr);
		}
		System.out.println(String.format("%.30f", sum));
	}
}
