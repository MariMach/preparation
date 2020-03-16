import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CampSchedule {
	  public static void main(String args[] ) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  	String s = br.readLine();
			String t = br.readLine();
			String n = "";
			int nb0 = 0, nb1 = 0, nb0t = 0, nb1t = 0, a = 0;
			for(int i = 0; i < t.length(); i++) {
				if(t.charAt(i) == '0') {
					nb0++;
				}else {
					nb1++;
				}
			}
			for(int i = 0; i < s.length(); i++) {
				n = s.charAt(i) + n;
				if(s.charAt(i) == '0') {
					nb0t++;
				} else {
					nb1t++;
				}
			}
			for(int i = 0; i < a; i++) {
				System.out.print(t);
			}
			System.out.print(n.substring(0,s.length()-(a*t.length())));
	}
}
