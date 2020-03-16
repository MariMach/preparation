import java.io.*;
import java.util.*;
 
import static java.lang.System.out;

public class binaryMatrix {
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
 
    static class Print {
        private BufferedWriter bw;
 
        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(out));
        }
 
 
        public void print(Object object) throws IOException {
            bw.append("" + object);
        }
 
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
 
 
        public void close() throws IOException {
            bw.close();
        }
 
    }
 
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int rows = fr.nextInt();
        int columns = fr.nextInt();
        int kmax = 1;
        String Nmax = fr.nextLine();
        for (int i = 2; i <= rows; i++){
            String N = fr.nextLine();
            int k = 0;
            while(k < columns) {
            	if(N.charAt(k)>Nmax.charAt(k)) {
            		Nmax= N;
					kmax = i;
					break;
            	}else if(N.charAt(k) == Nmax.charAt(k)) {
					k++;
				} else {
					break;
				}
            }
        }
        print.println(kmax);
        print.close();
    }
 
}