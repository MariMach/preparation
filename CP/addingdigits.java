import java.util.Scanner;

public class addingdigits {

	public static void main(String[]argv) {		
		Scanner S  = new Scanner(System.in);
		
		String A = S.next();
		int a = Integer.valueOf(A);
		String B = S.next();
		int b = Integer.valueOf(B);
		int initial = b;
		String N = S.next();
		int n = Integer.valueOf(N);
		
		int i = 1;
		String Switch = B; 
		
		while(B.length() <= (A.length()+n) &&  ! Switch.substring(0,A.length()).equals(A)) {			
				b = initial*i;/
				i++;
				Switch = Integer.toString(b);
				B = Integer.toString(b);
		}
		
		if(B.substring(0,A.length()).equals(A)) System.out.println(b);
		else System.out.println(-1);
		
	}

}