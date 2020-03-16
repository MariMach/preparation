import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class addingdigitss {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	   	 StringTokenizer st = new StringTokenizer(br.readLine());
  	   	 String a = st.nextToken();
  	   	 int b = Integer.parseInt(st.nextToken());
  	   	 int n = Integer.parseInt(st.nextToken());
  	   	 int flag = 0, i = 0;
  	   	 for( i = 0; i < 10; i++) {
  	   		 int aa = Integer.parseInt(a + "" + i);
  	   		 if(aa%b == 0) {
  	   			 flag = 1;
  	   			 break;
  	   		 }
  	   	 }
  	   	 if(flag == 1) {
  	   		 a = a + i;
  	   		 int newa = Integer.parseInt(a);
  	   		 int r =(int) ((int) newa*Math.pow(10, n-1));
  	   		 System.out.println(r);
  	   	 }else {
  	   		 System.out.println(-1);
  	   	 }

	}
}
