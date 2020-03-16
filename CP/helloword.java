import java.io.BufferedReader;
import java.io.InputStreamReader;

public class helloword {
	  public static void main(String args[] ) throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  long t = Long.parseLong(br.readLine()); 
		  System.out.println("Hello world!");
	  }
}
