import java.io.*;
import java.util.HashMap;

public class superheros {
	  public static void main(String args[] ) throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  String name1 = br.readLine();
		  String name2 = br.readLine();
		  HashMap<Character, Integer> hm = new  HashMap<Character, Integer>();
		  hm.put('a', 0);
		  hm.put('e', 0);
		  hm.put('u', 0);
		  hm.put('o', 0);
		  hm.put('i', 0);
		  int flag = 1;
		  if(name1.length() != name2.length()) {
			  System.out.println("No");
		  }else {
			  for(int i = 0; i < name1.length(); i++) {
				  if( (hm.containsKey(name1.charAt(i))) && (hm.containsKey(name2.charAt(i)) )) {
					  continue;
				  }
				  if( !(hm.containsKey(name1.charAt(i))) && (!hm.containsKey(name2.charAt(i)) )) {
					  continue;
				  }
				  flag = 0;
			  }
			  if(flag == 0) {
				  System.out.println("No");
			  }else {
				  System.out.println("Yes");
			  }
			  
		  }
		  
	  }
}
