
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class turtle {

	public static void main(String[] args) throws Exception {

		MyScanner scanner = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);

		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			double x = 0;
			double y = 0;
			double alpha = 0;

			for (int i = 0; i < n; ++i) {
				String command = scanner.next();

				if (command.equals("fd")) {

					int distance = scanner.nextInt();
					x += distance * Math.cos(Math.PI * alpha / 180);
					y += distance * Math.sin(Math.PI * alpha / 180);

				} else if (command.equals("lt")) {

					alpha += scanner.nextDouble();

				} else if (command.equals("bk")) {

					int distance = scanner.nextInt();
					x -= distance * Math.cos(Math.PI * alpha / 180);
					y -= distance * Math.sin(Math.PI * alpha / 180);

				} else if (command.equals("rt")) {
					alpha -= scanner.nextDouble();
				}
			}

			double far = Math.sqrt(x * x + y * y);
			out.println((long) Math.round(far));
		}

		out.close();
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() throws FileNotFoundException {
			// br = new BufferedReader (new InputStreamReader(new
			// FileInputStream("input.txt")));
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}