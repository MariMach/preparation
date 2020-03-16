import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class hosAnswer {
				
	
	static final int MAX = (int)1e3;
	static final int MOD = (int)1e9 + 7;
	public static void main(String[] args) throws Exception {
					
		InputReader scanner = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = scanner.nextInt();
		int[] h = new int[n];
		for(int i = 0; i < n; ++i) h[i] = scanner.nextInt();
		
		int[] count = new int[MAX + 1];
		for(int k : h) count[k]++;
		
		long res = 0;
		
		int acc = 0;
		for(int x = 1; x <= MAX ; ++x) {
			if(count[x] > 0) {
				long p = pow(2, count[x]) - 1;
				long pp = pow(2, acc);
				
				if(pp < 0) pp += MOD;
				if(p < 0) p += MOD; 
				
				res = (res + ((p * pp) % MOD)* x) % MOD;
				acc += count[x];
			}
		}
		
		acc = 0;
		for(int x = MAX; x >= 1 ; --x) {
			if(count[x] > 0) {
				long p = pow(2, count[x]) - 1;
				long pp = pow(2, acc) ;

				if(p < 0) p = (p + MOD);
				if(pp < 0) pp = (pp + MOD);
				 	
				res = (res - ((p * pp) % MOD)* x) % MOD;
				if(res < 0) res += MOD;
				acc += count[x];
			}
		}
		
		out.println(res);
		
		
		
		out.close();
	
	}
	
	static long pow(long x, long n) {
		if(n == 0) return 1;
		if(n % 2 == 0) return pow((x * x) % MOD, n / 2);
		return (x * pow((x * x) % MOD, (n - 1) / 2)) % MOD;
	}
	
	
	static class InputReader {

	    private InputStream stream;
	    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
	    private static final int EOF = -1;
	    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
	    private int curChar;
	    private int numChars;

	    public InputReader(InputStream stream) {
	      this.stream = stream;
	    }

	    public int read() {
	      if (this.numChars == EOF) {
	        throw new UnknownError();
	      } else {
	        if (this.curChar >= this.numChars) {
	          this.curChar = 0;

	          try {
	            this.numChars = this.stream.read(this.buf);
	          } catch (IOException ex) {
	            throw new InputMismatchException();
	          }

	          if (this.numChars <= 0) {
	            return EOF;
	          }
	        }

	        return this.buf[this.curChar++];
	      }
	    }

	    public int nextInt() {
	      int c;
	      for (c = this.read(); isSpaceChar(c); c = this.read()) {
	      }

	      byte sgn = 1;
	      if (c == 45) {
	        sgn = -1;
	        c = this.read();
	      }

	      int res = 0;

	      while (c >= 48 && c <= 57) {
	        res *= 10;
	        res += c - 48;
	        c = this.read();
	        if (isSpaceChar(c)) {
	          return res * sgn;
	        }
	      }

	      throw new InputMismatchException();
	    }

	    public static boolean isSpaceChar(int c) {
	      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
	    }

	    public int[] nextIntArray(int n) {
	      int[] arr = new int[n];
	      for (int i = 0; i < n; i++) {
	        arr[i] = nextInt();
	      }
	      return arr;
	    }

	  }

					
					
				
	static class MyScanner {
				BufferedReader br;
				StringTokenizer st;
 
				public MyScanner() throws FileNotFoundException {
				  // br = new BufferedReader	(new InputStreamReader(new FileInputStream("input.txt")));
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