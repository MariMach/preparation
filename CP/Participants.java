package maths;

import java.io.*;
import java.util.*;
 
import static java.lang.System.out;



	class Participants {

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
	    public static long nmatches(long n){
	        if(n == 2){
	            return 1;
	        } else if(n <= 1){
	            return 1;
	        }
	        if(n % 2 == 0){ // is even
	             return 1 + nmatches(n/2);
	        } else { // is odd
	             return 1 + nmatches(n-1);
	        }
	    }
	 
	    public static void main(String args[] ) throws Exception {
	        long highestn = 0, nparticipants = 0; 
	        FastReader fr = new FastReader();
	        Print print = new Print();
	        nparticipants = fr.nextLong();
	        highestn = nmatches(nparticipants);
	        print.println(highestn);
	        print.close();
	    }
	 
	}
