import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Sieve {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    static int mod = 200;
    static int a[] = new int[mod + 1];

    public static void sieve() {
        a[0] = a[1] = 1;
        for (int i = 2; i <= Math.sqrt(mod); i++) {
            System.out.println("i = " + i);
            if (a[i] == 0) {
                for (int j = i * 2; j <= mod; j += i) {
                    System.out.println(j);
                    a[j] = 1;
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int T = fr.nextInt();
        sieve();
        for (int i = 1; i <= T; i++) {
            int N = fr.nextInt();
            for (int j = N, k = N;; j--, k++) {
                if (a[j] == 0) {
                    print.println(j);
                    break;
                } else if (a[k] == 0) {
                    print.println(k);
                    break;
                }
            }
        }

        print.close();
    }

}