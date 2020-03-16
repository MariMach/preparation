import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class mt {
   public static HashMap<Integer, String> hm = new HashMap<Integer, String>();
   public static HashMap<Integer, String> hmm = new HashMap<Integer, String>();
   public static int jour;
   public static int cost ;
   public static int n;
   public static int m;
   public static int d;

	  public static int Maxcost(String a) {
		  	int m=0,k=0;
		  	String city;
		  	if(jour <= d){
		  		System.out.println("############## = "+jour);
			  	if(a.length() == 1) {
			  		k = Integer.parseInt(a);
			  		city = hmm.get(k);
			  		if(city.charAt((jour-1)) == '1')
			  			return 1 + Maxcost(hm.get(k));
			  		else 
			  			return Maxcost(hm.get(k));
			  	}else {
			  		int imax=0;
			  		int max = Maxcost(a.charAt(0)+"");
			  		 for(int i = 1; i < a.length(); i++) {
			  			 m = Maxcost(a.charAt(i)+"");
			  			 if(m > max) {
			  				 max = m;imax=i;
			  			 }		  			 
					    }
			  		 return max + Maxcost(hm.get(imax));
			  	}
		  	}else	return 0;
		   
	  }
	  public static void main(String args[] ) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    n = Integer.parseInt(st.nextToken());
		    m = Integer.parseInt(st.nextToken());
		    d = Integer.parseInt(st.nextToken());
		    cost = 0;
		    jour = 0;
		    for(int i = 0; i < m; i++) {
		    	 StringTokenizer stt = new StringTokenizer(br.readLine());
		    	 int a = Integer.parseInt(stt.nextToken());
		    	 if(hm.containsKey(a)) {
		    		 hm.put(a, hm.get(a)+stt.nextToken());
		    	 }else {
		    		 hm.put(a, stt.nextToken());
		    	 }
		    }
		    for(int i = 0; i < n; i++) {
		    	String s = br.readLine();
		    	hmm.put(i+1, s);
		    }
		    cost = Maxcost(1+"");
		    System.out.println("cost = "+ cost);

	  }
}