import java.io.*;
import java.util.*;
 
import static java.lang.System.out;



public class UncowedForces {
	
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
	        ArrayList<Integer> ms = new ArrayList<Integer>();
	        String a;
	        while( (a = fr.next()) != null) {
		        ms.add(Integer.parseInt(a));
	        }
	        for(int i = 0; i < ms.size(); i++) {
	        	print.println(ms.get(i));
	        }
	        print.close();
	    }

}
